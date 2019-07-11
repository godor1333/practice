package com.company.model.states;

import com.company.model.GraphCreatorModel;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

//Описывает состояние движения вершин
public class MoveState implements State {

    private final GraphCreatorModel model;
    private mxCell currentCell = null;

    public MoveState(GraphCreatorModel graphCreatorModel) {
        this.model = graphCreatorModel;
        ((mxGraph)model.getGraph()).setCellsSelectable(true);
        ((mxGraph)model.getGraph()).setCellsMovable(true);
    }

    @Override
    public void nextStep() {
    }

    @Override
    public void backStep() {
    }

    @Override
    public void startAlgorithm() {
    }

    @Override
    public void finishAlgorithm() {
    }

    @Override
    public void resetAlgorithm() {
    }

    @Override
    public void mousePressed(double posX, double posY, Object cell) {

        if (cell != null&&((mxCell) cell).isVertex()) {
            currentCell = (mxCell) cell;
            model.setStyleSelected(true, new Object[]{cell});
        }
    }

    @Override
    public void mouseReleased(double posX, double posY, Object cell) {
        if (currentCell != null) {
            model.setStyleSelected(false, new Object[]{currentCell});
            currentCell = null;
        }
    }

    @Override
    public String getStatus() {
        return currentCell == null ? "Выделите и перемещайте объекты" : "Перемещайте курсор для перемещения объекта";
    }

    @Override
    public void close() {
        ((mxGraph)model.getGraph()).setCellsSelectable(false);
        ((mxGraph)model.getGraph()).setCellsMovable(false);
        model.setNormalStyle();
    }
}
