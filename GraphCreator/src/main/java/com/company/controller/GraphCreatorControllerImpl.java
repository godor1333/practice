package com.company.controller;

import com.company.model.GraphCreatorModel;
import com.company.model.adapter.GraphAdapter;
import com.company.model.states.*;
import com.company.view.GraphCreatorView;

import java.awt.event.MouseEvent;
import java.io.*;

public class GraphCreatorControllerImpl implements GraphCreatorController {

    private final GraphCreatorModel model;
    private final GraphAdapter adapter;
    private GraphCreatorView view;
    private State currentState;

    public GraphCreatorControllerImpl(GraphCreatorModel model,GraphAdapter adapter) {
        this.model = model;
        this.adapter = adapter;
    }

    @Override
    public void saveGraph() {
        File file = view.showFileChooserDialog("Сохранить граф");
        if (file != null) {
            try {
                model.saveGraph(file.getAbsoluteFile().toString());
            } catch (IOException e) {
                view.showErrorDialog("Ошибка", "Не удалось сохраненить граф. Попробуйте еще раз!");
            }
        }
    }

    @Override
    public void loadGraph() {
        File file = view.showFileChooserDialog("Загрузить граф");
        if (file != null) {
            try {
                model.loadGraph(file.getAbsoluteFile().toString());
            } catch (Exception e) {
                view.showErrorDialog("Ошибка", "Не удалось загрузить граф. Попробуйте еще раз!");
            }
        }
    }

    @Override
    public void setStateOfMotion() {
        currentState.close();
        currentState = new MoveState(model);
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void setStateOfAddingVertices() {
        currentState.close();
        currentState = new AddVertexState(model, view);
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void setStateOfConnectionVertices() {
        currentState.close();
        currentState = new ConnectionVertexState(model, view);
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void setStateOfDelete() {
        currentState.close();
        currentState = new DeleteState(model);
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void setStateOfAlgorithm() {
        currentState.close();
        if(!(currentState instanceof AlgorithmShortestWayState)) {
           currentState = new AlgorithmShortestWayState(model, view, adapter);
        }
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void nextStep() {
        currentState.nextStep();
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void backStep() {
        currentState.backStep();
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void mousePressed(MouseEvent e, Object cell) {
        currentState.mousePressed(e.getX(), e.getY(), cell);
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void mouseReleased(MouseEvent e, Object cell) {
        if (e != null)
            currentState.mouseReleased(e.getX(), e.getY(), cell);
        else
            currentState.mouseReleased(-1, -1, cell);
        view.setLabelHelp(currentState.getStatus());
    }

    @Override
    public void setView(GraphCreatorView view) {
        this.view = view;
        currentState = new AddVertexState(model, view);
        view.setLabelHelp(currentState.getStatus());
    }
}
