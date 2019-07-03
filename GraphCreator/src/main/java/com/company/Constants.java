package com.company;

public interface Constants {

    interface Algorithms {
        String DIJKSTRA = "Алгоритм Дейкстры";
        String FORD_BELLMAN = "Алгоритм Форда-Беллмана";
        String ASTAR = "Алгоритм A*";
    }

    interface Size {
        double WIDTH_VERTEX = 40;
        double HEIGHT_VERTEX = 40;
        int MAX_SIZE_VERTEX_NAME = 15;
        int WIDTH = 1000;
        int HEIGHT = 800;
        int INTEND = 5;
    }

    interface StyleGraph {
        String MY_CUSTOM_VERTEX_NORMAL_STYLE = "MY_CUSTOM_VERTEX_NORMAL_STYLE";
        String MY_CUSTOM_CURRENT_VERTEX_STYLE = "MY_CUSTOM_CURRENT_VERTEX_STYLE";
        String MY_CUSTOM_IN_QUEUE_VERTEX_STYLE = "MY_CUSTOM_IN_QUEUE_VERTEX_STYLE";
        String MY_CUSTOM_EDGE_NORMAL_STYLE = "MY_CUSTOM_EDGE_NORMAL_STYLE";
        String MY_CUSTOM_VERTEX_SELECTED_STYLE = "MY_CUSTOM_VERTEX_SELECTED_STYLE";
        String MY_CUSTOM_EDGE_SELECTED_STYLE = "MY_CUSTOM_EDGE_SELECTED_STYLE";
        String STROKE_COLOR_NORMAL = "#cdc4d1";
        String FILL_COLOR_NORMAL = "#67adb9";
        String FONT_COLOR_NORMAL = "#fecb16";
        String STROKE_COLOR_SELECTED = "#fecb16";
        String FILL_COLOR_SELECTED = "#c66179";
        String FONT_COLOR_SELECTED = "#fecb16";
        String STROKE_VERTEX_SIZE = "1";
        String STROKE_EDGE_SIZE = "3";
        String FONT_SIZE = "14";
        String GREEN_COLOR = "#228B22";
    }

    interface NameButton{
        String SAVE = "Сохранить";
        String LOAD = "Загрузить";
        String MOVE = "Перемещение";
        String ADD_VERTEX = "Добавить вершину";
        String CONNECT_VERTEX = "Соединить вершины";
        String DELETE = "Удалить";
        String NEXT = "Вперед";
        String BACK = "Назад";
    }

    String SEPARATOR = "$";
}
