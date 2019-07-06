package shortest.way;

import model.graph.DirectedEdge;

import java.util.PriorityQueue;
import java.util.Stack;

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
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getFrom()])
            path.push(e);
        return path;
    }
}
