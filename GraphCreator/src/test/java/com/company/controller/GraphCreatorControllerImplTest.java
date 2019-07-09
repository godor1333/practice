package com.company.controller;

import com.company.model.GraphCreatorModel;
import com.company.model.GraphCreatorModelImpl;
import com.company.model.adapter.GraphAdapter;
import com.company.model.adapter.MxGraphAdapter;
import com.company.model.states.*;
import com.company.view.GraphCreatorView;
import com.company.view.GraphCreatorViewImpl;
import org.junit.*;

import static org.junit.Assert.*;

public class GraphCreatorControllerImplTest {

    private State currentState;
    private GraphCreatorModel model;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before GraphCreatorControllerImpl ");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After GraphCreatorControllerImpl");
    }

    @Before
    public void initTest() {
        model = new GraphCreatorModelImpl();
    }

    @After
    public void afterTest() {
        currentState = null;
        model = null;
    }

    @Test
    public void setStateOfMotion() {
        currentState = new MoveState(model);
        assertEquals("Выделите и перемещайте объекты",currentState.getStatus());
    }

    @Test
    public void setStateOfAddingVertices() {
        currentState = new AddVertexState(model,null);
        assertEquals("Кликните на рабочую область, чтобы добавить вершину",currentState.getStatus());
    }

    @Test
    public void setStateOfConnectionVertices() {
        currentState = new ConnectionVertexState(model,null);
        assertEquals("Выделите первую вершину для создания дуги",currentState.getStatus());
    }

    @Test
    public void setStateOfDelete() {
        currentState = new DeleteState(model);
        assertEquals("Кликните по объекту, который хотите удалить",currentState.getStatus());
    }

    @Test
    public void setStateOfAlgorithm() {
        currentState = new AlgorithmShortestWayState(model,null,null);
        assertEquals("Выделите вершину, из которой хотите найти кратчайших путь",currentState.getStatus());
    }
}