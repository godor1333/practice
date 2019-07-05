package com.company.model.algorithms;

import com.mxgraph.model.mxCell;

import java.awt.*;

public class MementoShortestWayView {
    private final Object currentVertex;
    private final Object[] processedVertices;
    private final Object[] currentWays;
    private final Object[] inQueueVertices;
    private final Object[] answer;
    private final String log;

    public MementoShortestWayView(Object currentVertex,
                                  Object[] processedVertices,
                                  Object[] currentWays,
                                  Object[] inQueueVertices,
                                  Object[] answer,
                                  String log) {
        this.currentVertex = currentVertex;
        this.processedVertices = processedVertices;
        this.currentWays = currentWays;
        this.inQueueVertices = inQueueVertices;
        this.answer = answer;
        this.log = log;
    }

    public Object getCurrentVertex() {
        return currentVertex;
    }

    public Object[] getProcessedVertices() {
        return processedVertices;
    }

    public Object[] getCurrentWays() {
        return currentWays;
    }

    public Object[] getInQueueVertices() {
        return inQueueVertices;
    }

    public Object[] getAnswer() {
        return answer;
    }

    public String getLog() {
        return log;
    }
}
