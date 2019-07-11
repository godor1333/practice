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
        int INTEND = 5;
    }

    interface StyleGraph {
        String MY_CUSTOM_VERTEX_NORMAL_STYLE = "MY_CUSTOM_VERTEX_NORMAL_STYLE";
        String MY_CUSTOM_CURRENT_VERTEX_STYLE = "MY_CUSTOM_CURRENT_VERTEX_STYLE";
        String MY_CUSTOM_IN_QUEUE_VERTEX_STYLE = "MY_CUSTOM_IN_QUEUE_VERTEX_STYLE";
        String MY_CUSTOM_EDGE_NORMAL_STYLE = "MY_CUSTOM_EDGE_NORMAL_STYLE";
        String MY_CUSTOM_VERTEX_SELECTED_STYLE = "MY_CUSTOM_VERTEX_SELECTED_STYLE";
        String MY_CUSTOM_EDGE_SELECTED_STYLE = "MY_CUSTOM_EDGE_SELECTED_STYLE";
        String STROKE_COLOR_NORMAL ="#996AD6";//"#cdc4d1";
        String FILL_COLOR_NORMAL ="#FFF273";//"#67adb9";
        String FONT_COLOR_NORMAL = "#530FAD";//"#fecb16";
        String STROKE_COLOR_SELECTED = "#4F2982";//"#fecb16";
        String FILL_COLOR_SELECTED = "#FF0000";//"#c66179";
        String FONT_COLOR_SELECTED = "#FFFF00";//"#530FAD";//"#fecb16";
        String STROKE_VERTEX_SIZE = "3";
        String STROKE_EDGE_SIZE = "3";
        String FONT_SIZE = "14";
        String STROKE_COLOR_CURRENT = "#67E300";//"#fecb16";
        String FILL_COLOR_CURRENT = "#A9F16D";//"#c66179";
        String FONT_COLOR_CURRENT = "#000000";//"#530FAD";//"#fecb16";
    }

    interface NameButton {
        String SAVE = "Сохранить";
        String LOAD = "Загрузить";
        String MOVE = "Перемещение";
        String ADD_VERTEX = "Добавить вершину";
        String CONNECT_VERTEX = "Соединить вершины";
        String DELETE = "Удалить";
        String NEXT = "Вперед";
        String BACK = "Назад";
        String START = "Старт";
        String FINISH = "Завершить";
        String RESET = "Сбросить";
    }

    String SEPARATOR = "$";
}
