package shortest.way;

import model.graph.DirectedEdge;

import java.util.PriorityQueue;

public class Dijkstra implements ShortestWayAlgorithm {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] visitedVertex;
    private PriorityQueue<Double> priorityQueue;

    @Override
    public boolean hasPathTo(int v) {
        return false;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        return null;
    }
}
