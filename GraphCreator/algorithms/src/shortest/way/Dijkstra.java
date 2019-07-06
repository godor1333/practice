package shortest.way;

import model.graph.Digraph;
import model.graph.DirectedEdge;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra implements ShortestWayAlgorithm {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] visitedVertex;
    private PriorityQueue<Double> priorityQueue;

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getFrom()])
            path.push(e);
        return path;
    }

    @Override
    public List<MementoShortestWay> buildWay(Digraph G, int source, int target) {
        return null;
    }
}
