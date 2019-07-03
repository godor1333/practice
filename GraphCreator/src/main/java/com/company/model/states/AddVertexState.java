package com.company.model.states;

import com.company.model.GraphCreatorModel;
import com.company.view.GraphCreatorView;

import javax.swing.*;

import static com.company.Constants.Size.WIDTH_VERTEX;
import static com.company.Constants.Size.HEIGHT_VERTEX;

//Описывает состояние добавления вершины
public class AddVertexState implements State {

    private final GraphCreatorModel model;
    private final GraphCreatorView view;

    public AddVertexState(GraphCreatorModel model, GraphCreatorView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void nextStep() {
    }

    @Override
    public void backStep() {
    }

    @Override
    public void mousePressed(double posX, double posY, Object cell) {
        String name = view.showInputDialog("Добавить вершину", "Введите название вершины");
        if (name != null && !name.isEmpty()) {
            if (!model.addVertex(name, posX - WIDTH_VERTEX / 2, posY - HEIGHT_VERTEX / 2, WIDTH_VERTEX, HEIGHT_VERTEX)) {
                view.showErrorDialog("Ошибка", "Такая вершина уже существует!");
            }
        }
    }

    @Override
    public void mouseReleased(double posX, double posY, Object cell) {
    }

    @Override
    public String getStatus() {
        return "Кликните на рабочую область, чтобы добавить вершину";
    }

    @Override
    public void close() {
    }
}
