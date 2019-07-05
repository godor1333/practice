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
        for (Object v : graph.getChildVertices(parent)) {
            if (((mxCell) v).getValue().equals(name))
                return false;
        }
        if (name.length() > MAX_SIZE_VERTEX_NAME)
            name = name.substring(0, MAX_SIZE_VERTEX_NAME) + "...";
        graph.getModel().beginUpdate();
        graph.insertVertex(parent, null, name, posX, posY, width, height, MY_CUSTOM_VERTEX_NORMAL_STYLE);
        graph.getModel().endUpdate();
        return true;
    }

    @Override
    public boolean addEdge(String weight, Object v1, Object v2) {
        try {
            Double.parseDouble(weight);
            graph.getModel().beginUpdate();
            graph.insertEdge(parent, null, weight, v1, v2, MY_CUSTOM_EDGE_NORMAL_STYLE);
            graph.getModel().endUpdate();
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public void delete(Object[] cells) {
        graph.getModel().beginUpdate();
        graph.removeCells(cells);
        graph.getModel().endUpdate();
    }

    @Override
    public int checkExistEdge(Object s, Object t) {
        mxCell sourceVertex = (mxCell) s;
        mxCell targetVertex = (mxCell) t;
        for (int i = 0; i < sourceVertex.getEdgeCount(); i++) {
            mxCell target = (mxCell) ((mxCell) (sourceVertex.getEdgeAt(i))).getTarget();
            if (target == targetVertex)
                return i;
        }
        return -1;
    }

    @Override
    public void setNormalStyle() {
        graph.setCellStyle(MY_CUSTOM_EDGE_NORMAL_STYLE, graph.getChildEdges(graph.getDefaultParent()));
        graph.setCellStyle(MY_CUSTOM_VERTEX_NORMAL_STYLE, graph.getChildVertices(graph.getDefaultParent()));
    }

    @Override
    public void setStyleSelected(boolean flag, Object[] cells) {
        for (Object c : cells) {
            mxCell cell = (mxCell) c;
            if (flag) {
                if (cell.isVertex()) {
                    graph.setCellStyle(MY_CUSTOM_VERTEX_SELECTED_STYLE, new Object[]{cell});
                } else if (cell.isEdge())
                    graph.setCellStyle(MY_CUSTOM_EDGE_SELECTED_STYLE, new Object[]{cell});
            } else {
                if (cell.isVertex())
                    graph.setCellStyle(MY_CUSTOM_VERTEX_NORMAL_STYLE, new Object[]{cell});
                else if (cell.isEdge())
                    graph.setCellStyle(MY_CUSTOM_EDGE_NORMAL_STYLE, new Object[]{cell});
            }
        }
    }

    @Override
    public void setStyle(String style, Object[] cells) {
        graph.setCellStyle(style, cells);
    }

    @Override
    public void saveGraph(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(graph.getChildCells(parent));
        }

    }

    @Override
    public void loadGraph(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            graph.removeCells(graph.getChildCells(parent));
            graph.addCells((Object[]) inputStream.readObject());
        }
    }

    @Override
    public Object getGraph() {
        return graph;
    }
}
