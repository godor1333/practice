package com.company.model;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import org.junit.*;

import static org.junit.Assert.*;

public class GraphCreatorModelImplTest {

    GraphCreatorModelImpl model;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before GraphCreatorModelTest");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After GraphCreatorModelTest");
    }

    @Before
    public void initTest() {
        model = new GraphCreatorModelImpl();
    }

    @After
    public void afterTest() {
        model = null;
    }

    @Test
    public void addVertex() {
        mxGraph graph = (mxGraph) model.getGraph();
        model.addVertex("Hello",100,100,50,50);
        mxCell vertex=null;
        for(Object cell:graph.getChildVertices(graph.getDefaultParent())){
            if("Hello".equals(((mxCell)cell).getValue())){
                vertex = (mxCell) cell;
            }
        }
        assertNotNull(vertex);
        assertEquals("Hello",vertex.getValue());
    }

    @Test
    public void addEdge() {
        mxGraph graph = (mxGraph) model.getGraph();
        model.addVertex("Hi",100,100,50,50);
        model.addVertex("buy",500,500,20,40);
        Object[] vertices = graph.getChildVertices(graph.getDefaultParent());
        model.addEdge("123",vertices[0],vertices[1]);
        assertNotEquals(-1,model.checkExistEdge(vertices[0],vertices[1]));
    }

    @Test
    public void delete() {
        mxGraph graph = (mxGraph) model.getGraph();
        model.addVertex("Hi",100,100,50,50);
        model.delete(graph.getChildVertices(graph.getDefaultParent()));
        assertEquals(0,graph.getChildCells(graph.getDefaultParent()).length);
    }

}