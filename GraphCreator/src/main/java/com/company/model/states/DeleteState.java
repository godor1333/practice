package com.company.model.states;

import com.company.model.GraphCreatorModel;
import com.mxgraph.view.mxGraph;

//Описывает состояние удаление ребер и вершин
public class DeleteState implements State {

    private final GraphCreatorModel model;

    public DeleteState(GraphCreatorModel model) {
        this.model = model;
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
    public void mousePressed(double posX, double posY, Object cell) {
        if (cell != null) {
            Object[] cells = new Object[]{cell};
            model.delete(((mxGraph) model.getGraph()).getAllEdges(cells));
            model.delete(cells);
        }
    }

    @Override
    public void mouseReleased(double posX, double posY, Object cell) {
    }

    @Override
    public String getStatus() {
        return "Кликните по объекту, который хотите удалить";
    }

    @Override
    public void close() {
    }
}
