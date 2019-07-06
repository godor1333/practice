package shortest.way;

import model.graph.DirectedEdge;

import java.util.PriorityQueue;

public class MementoShortestWay {
    private final int currentVertex;
    private final boolean[] processedVertices;
    private final DirectedEdge[] currentWays;
    private final PriorityQueue<Double> inQueueVertices;

    public MementoShortestWay(int currentVertex, boolean[] processedVertices, DirectedEdge[] currentWays, PriorityQueue<Double> inQueueVertices) {
        this.currentVertex = currentVertex;
        this.processedVertices = processedVertices;
        this.currentWays = currentWays;
        this.inQueueVertices = inQueueVertices;
    }
}
