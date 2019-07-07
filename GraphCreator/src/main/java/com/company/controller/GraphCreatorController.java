package com.company.controller;

import com.company.view.GraphCreatorView;

import java.awt.event.MouseEvent;

/**
 * Публичный интерфейс контроллера(Выступает контекстом для состояний)
 * void setStateOfMotion() - установить состояние перемещения вершин
 * void setStateOfAddingVertices() - установить состояние добавления вершин
 * void setStateOfConnectionVertices() - установить состояние добавления ребер
 * void setStateOfDelete() - установить состояние удаления элементов графа
 * void setStateOfAlgorithm(String algorithm) - установить состояние выбранного алгоритма
 * void nextStep() - следующий шаг алгоримта
 * void backStep() - предыдущий шаг алгоритма
 * void mousePressed(MouseEvent e, Object cell) - обработка нажатие на кнопку мыши
 * void mouseReleased(MouseEvent e, Object cell) - обработка отпускания кнопки мыши
 * void setView(GraphCreatorView view) - установить представление
 */
public interface GraphCreatorController {
    void saveGraph();

    void loadGraph();

    void setStateOfMotion();

    void setStateOfAddingVertices();

    void setStateOfConnectionVertices();

    void setStateOfDelete();

    void setStateOfAlgorithm();

    void nextStep();

    void backStep();

    void startAlgorithm();

    void finishAlgorithm();

    void mousePressed(MouseEvent e, Object cell);

    void mouseReleased(MouseEvent e, Object cell);

    void setView(GraphCreatorView view);
}