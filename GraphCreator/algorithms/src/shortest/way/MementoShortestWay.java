package shortest.way;

import model.graph.DirectedEdge;
import model.graph.Entry;

import java.util.PriorityQueue;

public class MementoShortestWay {
    private final int currentVertex;
    private final boolean[] processedVertices;
    private final DirectedEdge[] currentWays;
    private final PriorityQueue<Entry> inQueueVertices;
    private final String[] log;

    public MementoShortestWay(int currentVertex, boolean[] processedVertices, DirectedEdge[] currentWays, PriorityQueue<Entry> inQueueVertices, String[] log) {
        this.currentVertex = currentVertex;
        this.processedVertices = processedVertices;
        this.currentWays = currentWays;
        this.inQueueVertices = inQueueVertices;
        this.log = log;
    }
}
