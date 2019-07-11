package com.company.model.states;

import com.company.model.GraphCreatorModel;
import com.company.view.GraphCreatorView;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

import javax.swing.*;

//Описывает состояние добавления ребра
public class ConnectionVertexState implements State {

    private final GraphCreatorModel model;
    private final GraphCreatorView view;
    private mxCell sourceVertex = null;

    public ConnectionVertexState(GraphCreatorModel model, GraphCreatorView view) {
        this.model = model;
        this.view = view;
    }

    //Обработка первого нажатия
    private void handlerFirstPressed(mxCell cell) {
        sourceVertex = cell;
        model.setStyleSelected(true, new Object[]{sourceVertex});
    }

    //Обработка второго нажатия
    private void handlerSecondPressed(mxCell cell) {
        if (model.checkExistEdge(sourceVertex, cell)==-1) {
            String weight = view.showInputDialog("Добавить ребро", "Введите вес ребра");
            if (weight != null && !weight.isEmpty()) {
                if (!model.addEdge(weight, sourceVertex, cell)) {
                    view.showErrorDialog("Ошибка", "Не правильный формат данных");
                }
            }
            model.setStyleSelected(false, new Object[]{sourceVertex});
            sourceVertex = null;
        }
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
        if (cell != null && ((mxCell) cell).isVertex()) {
            mxCell clickCell = (mxCell) cell;
            if (sourceVertex == null) {
                handlerFirstPressed(clickCell);
            } else {
                handlerSecondPressed(clickCell);
            }
        } else if (sourceVertex != null) {
            model.setStyleSelected(false, new Object[]{sourceVertex});
            sourceVertex = null;
        }
    }

    @Override
    public void mouseReleased(double posX, double posY, Object cell) {
    }

    @Override
    public String getStatus() {
        return sourceVertex == null ? "Выделите первую вершину для создания дуги" : "Выделите вторую вершину, которую хотите соединить";
    }

    @Override
    public void close() {
        model.setNormalStyle();
    }
}
