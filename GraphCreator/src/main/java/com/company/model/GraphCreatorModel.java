package com.company.model;

import java.io.IOException;

/**
 * Публичный интерфейс для модели графа
 * boolean addVertex(String name, double posX, double posY, double width, double height) - метод добавляет вершину в граф
 * boolean addEdge(String weight, Object vertex1, Object vertex2) - метод добавляет ребро между двумя вершинами
 * void delete(Object[] cells) - метод удаляет вершину и прилегающие ребра или просто ребро
 * boolean checkExistEdge(Object s, Object t) - метод проверяет, если ли ребро между двумя вершинами
 * void setNormalStyle() - устанавливает для всего графа нормальный стиль
 * void setStyleSelected(boolean flag, Object[] cells) - устанавливает или убирает выделенный стиль для ребер и вершин
 * Object getGraph() - возвращает граф
 * GraphAdapter getAdapter() - возвращает адаптер (для работы с алгоритмами)
 * void saveGraph(String fileName) throws IOException - сохранить граф
 * void loadGraph(String fileName) throws IOException, ClassNotFoundException - загрузить граф
 *
 */

public interface GraphCreatorModel {
    boolean addVertex(String name, double posX, double posY, double width, double height);

    boolean addEdge(String weight, Object vertex1, Object vertex2);

    void delete(Object[] cells);

    int checkExistEdge(Object s, Object t);

    void setNormalStyle();

    void setStyleSelected(boolean flag, Object[] cells);

    void setStyle(String style, Object[] cells);

    void saveGraph(String fileName) throws IOException;

    void loadGraph(String fileName) throws IOException, ClassNotFoundException;

    Object getGraph();
}
