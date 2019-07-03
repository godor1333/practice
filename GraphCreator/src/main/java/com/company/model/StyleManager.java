package com.company.model;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.company.Constants.StyleGraph.*;
import static com.company.Constants.StyleGraph.MY_CUSTOM_EDGE_SELECTED_STYLE;

class StyleManager {
    //Установить стиль для вершин в нормальном состоянии
    public static void initMyCustomVertexNormalStyle(mxGraph graph) {
        mxStylesheet stylesheet = graph.getStylesheet();
        Map<String, Object> vertexStyle = new Hashtable<>();
        vertexStyle.put(mxConstants.STYLE_FILLCOLOR, FILL_COLOR_NORMAL);
        vertexStyle.put(mxConstants.STYLE_FONTCOLOR, FONT_COLOR_NORMAL);
        vertexStyle.put(mxConstants.STYLE_STROKEWIDTH, STROKE_VERTEX_SIZE);
        vertexStyle.put(mxConstants.STYLE_STROKECOLOR, STROKE_COLOR_NORMAL);
        vertexStyle.put(mxConstants.STYLE_FONTSIZE, FONT_SIZE);
        vertexStyle.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        vertexStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        stylesheet.putCellStyle(MY_CUSTOM_VERTEX_NORMAL_STYLE, vertexStyle);
    }

    //Установить стиль для ребер в нормальном состоянии
    public static void initMyCustomEdgeNormalStyle(mxGraph graph) {
        mxStylesheet stylesheet = graph.getStylesheet();
        Map<String, Object> edgeStyle = new HashMap<>();
        edgeStyle.put(mxConstants.STYLE_ROUNDED, true);
        edgeStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
        edgeStyle.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        edgeStyle.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
        edgeStyle.put(mxConstants.STYLE_STROKECOLOR, STROKE_COLOR_NORMAL);
        edgeStyle.put(mxConstants.STYLE_FILLCOLOR, STROKE_COLOR_NORMAL);
        edgeStyle.put(mxConstants.STYLE_STROKEWIDTH, STROKE_EDGE_SIZE);
        edgeStyle.put(mxConstants.STYLE_FONTCOLOR, FONT_COLOR_NORMAL);
        edgeStyle.put(mxConstants.STYLE_FONTSIZE, FONT_SIZE);
        edgeStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        edgeStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, FILL_COLOR_NORMAL);
        edgeStyle.put(mxConstants.STYLE_LABEL_BORDERCOLOR, STROKE_COLOR_NORMAL);
        stylesheet.putCellStyle(MY_CUSTOM_EDGE_NORMAL_STYLE, edgeStyle);
    }

    //Установить стиль для вершин в выделеном состоянии
    public static void initMyCustomVertexSelectedStyle(mxGraph graph) {
        mxStylesheet stylesheet = graph.getStylesheet();
        Map<String, Object> vertexStyle = new Hashtable<>();
        vertexStyle.put(mxConstants.STYLE_FILLCOLOR, FILL_COLOR_SELECTED);
        vertexStyle.put(mxConstants.STYLE_FONTCOLOR, FONT_COLOR_SELECTED);
        vertexStyle.put(mxConstants.STYLE_STROKEWIDTH, STROKE_VERTEX_SIZE);
        vertexStyle.put(mxConstants.STYLE_STROKECOLOR, STROKE_COLOR_SELECTED);
        vertexStyle.put(mxConstants.STYLE_FONTSIZE, FONT_SIZE);
        vertexStyle.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        vertexStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        stylesheet.putCellStyle(MY_CUSTOM_VERTEX_SELECTED_STYLE, vertexStyle);
    }

    //Установить стиль для ребер в выделеном состоянии
    public static void initMyCustomEdgeSelectedStyle(mxGraph graph) {
        mxStylesheet stylesheet = graph.getStylesheet();
        Map<String, Object> edgeStyle = new Hashtable<>();
        edgeStyle.put(mxConstants.STYLE_ROUNDED, true);
        edgeStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
        edgeStyle.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        edgeStyle.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
        edgeStyle.put(mxConstants.STYLE_STROKECOLOR, STROKE_COLOR_SELECTED);
        edgeStyle.put(mxConstants.STYLE_FILLCOLOR, STROKE_COLOR_SELECTED);
        edgeStyle.put(mxConstants.STYLE_STROKEWIDTH, STROKE_EDGE_SIZE);
        edgeStyle.put(mxConstants.STYLE_FONTCOLOR, FONT_COLOR_SELECTED);
        edgeStyle.put(mxConstants.STYLE_FONTSIZE, FONT_SIZE);
        edgeStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        edgeStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, FILL_COLOR_SELECTED);
        edgeStyle.put(mxConstants.STYLE_LABEL_BORDERCOLOR, STROKE_COLOR_SELECTED);
        edgeStyle.put(mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_BOTTOM);
        stylesheet.putCellStyle(MY_CUSTOM_EDGE_SELECTED_STYLE, edgeStyle);
    }

    public static void initMyCustomCurrentVertexStyle(mxGraph graph) {
        mxStylesheet stylesheet = graph.getStylesheet();
        Map<String, Object> vertexStyle = new Hashtable<>();
        vertexStyle.put(mxConstants.STYLE_FILLCOLOR, GREEN_COLOR);
        vertexStyle.put(mxConstants.STYLE_FONTCOLOR, FONT_COLOR_SELECTED);
        vertexStyle.put(mxConstants.STYLE_STROKEWIDTH, STROKE_VERTEX_SIZE);
        vertexStyle.put(mxConstants.STYLE_STROKECOLOR, GREEN_COLOR);
        vertexStyle.put(mxConstants.STYLE_FONTSIZE, FONT_SIZE);
        vertexStyle.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        vertexStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        stylesheet.putCellStyle(MY_CUSTOM_CURRENT_VERTEX_STYLE, vertexStyle);
    }

    public static void initMyCustomInQueueVertexStyle(mxGraph graph) {
        mxStylesheet stylesheet = graph.getStylesheet();
        Map<String, Object> vertexStyle = new Hashtable<>();
        vertexStyle.put(mxConstants.STYLE_FILLCOLOR, FILL_COLOR_NORMAL);
        vertexStyle.put(mxConstants.STYLE_FONTCOLOR, FONT_COLOR_SELECTED);
        vertexStyle.put(mxConstants.STYLE_STROKEWIDTH, "3");
        vertexStyle.put(mxConstants.STYLE_STROKECOLOR, STROKE_COLOR_SELECTED);
        vertexStyle.put(mxConstants.STYLE_FONTSIZE, FONT_SIZE);
        vertexStyle.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        vertexStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        vertexStyle.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        stylesheet.putCellStyle(MY_CUSTOM_IN_QUEUE_VERTEX_STYLE, vertexStyle);
    }
}
