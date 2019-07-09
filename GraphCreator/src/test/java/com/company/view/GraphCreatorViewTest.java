package com.company.view;

import com.company.controller.GraphCreatorControllerImpl;
import com.company.model.GraphCreatorModel;
import com.company.model.GraphCreatorModelImpl;
import com.company.model.adapter.MxGraphAdapter;
import org.junit.*;

import javax.swing.*;

import static org.junit.Assert.*;

public class GraphCreatorViewTest {

    private GraphCreatorViewImpl view;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before GraphCreatorViewTest");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After GraphCreatorViewTest");
    }

    @Before
    public void initTest() {
        GraphCreatorModel graphCreatorModel = new GraphCreatorModelImpl();
        GraphCreatorControllerImpl graphCreatorController = new GraphCreatorControllerImpl(graphCreatorModel,new MxGraphAdapter());
        view= new GraphCreatorViewImpl(graphCreatorController, graphCreatorModel);
    }

    @After
    public void afterTest() {
        view = null;
    }

    @Test
    public void TestClickMoveButton(){
        view.getToolBar().getMoveButton().doClick();
        assertEquals("Выделите и перемещайте объекты",view.getToolBar().getLabelHelp().getText());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestClickDeleteButton(){
        view.getToolBar().getDeleteButton().doClick();
        assertEquals("Кликните по объекту, который хотите удалить",view.getToolBar().getLabelHelp().getText());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestClickAddVertexButton(){
        view.getToolBar().getAddVertexButton().doClick();
        assertEquals("Кликните на рабочую область, чтобы добавить вершину",view.getToolBar().getLabelHelp().getText());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestClickConnectionVertexButton(){
        view.getToolBar().getConnectVertexButton().doClick();
        assertEquals("Выделите первую вершину для создания дуги",view.getToolBar().getLabelHelp().getText());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}