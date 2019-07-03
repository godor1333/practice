package com.company.model;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxEdgeStyle;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import org.jgraph.event.GraphModelEvent;
import org.jgraph.event.GraphModelListener;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.company.Constants.Size.MAX_SIZE_VERTEX_NAME;
import static com.company.Constants.StyleGraph.*;

public class GraphCreatorModelImpl implements GraphCreatorModel {

    private final mxGraph graph;
    private final Object parent;

    public GraphCreatorModelImpl() {
        this.graph = new mxGraph();
        this.parent = graph.getDefaultParent();
        graph.setCellsEditable(false);//Нельзя редактировать
        graph.setCellsResizable(false);//Нельзя изменять текст
        graph.setDisconnectOnMove(false);//Нельзя двигать ребро
        graph.setCellsDisconnectable(false);//Нельзя отрывать ребро от вершины
        graph.setEdgeLabelsMovable(false);//Нельзя двигать именную метку ребра
        graph.setKeepEdgesInBackground(true);//Ребра на заднем плане
        graph.setCellsSelectable(false);
        graph.setCellsMovable(false);
        StyleManager.initMyCustomEdgeNormalStyle(graph);
        StyleManager.initMyCustomEdgeSelectedStyle(graph);
        StyleManager.initMyCustomVertexNormalStyle(graph);
        StyleManager.initMyCustomVertexSelectedStyle(graph);
        StyleManager.initMyCustomCurrentVertexStyle(graph);
        StyleManager.initMyCustomInQueueVertexStyle(graph);
    }


    @Override
    public boolean addVertex(String name, double posX, double posY, double width, double height) {

        return true;
    }

    @Override
    public boolean addEdge(String weight, Object v1, Object v2) {

        return true;
    }

    @Override
    public void delete(Object[] cells) {

    }

    @Override
    public int checkExistEdge(Object s, Object t) {

        return -1;
    }

    @Override
    public void setNormalStyle() {

    }

    @Override
    public void setStyleSelected(boolean flag, Object[] cells) {

    }

    @Override
    public void setStyle(String style, Object[] cells) {
        graph.setCellStyle(style, cells);
    }

    @Override
    public void saveGraph(String fileName) throws IOException {


    }

    @Override
    public void loadGraph(String fileName) throws IOException, ClassNotFoundException {

    }

    @Override
    public Object getGraph() {
        return graph;
    }
}
