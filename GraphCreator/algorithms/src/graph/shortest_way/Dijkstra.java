package graph.shortest_way;

import graph.data_structures.Digraph;
import graph.data_structures.DirectedEdge;
import graph.data_structures.Entry;

import java.util.*;

public class Dijkstra implements ShortestWayAlgorithm {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] visitedVertex;
    private PriorityQueue<Entry> priorityQueue;
    private List<MementoShortestWay> steps;

    private void relax(Digraph graph, int vertex) {
        steps.add(new MementoShortestWay(vertex, visitedVertex, edgeTo, priorityQueue,
                new String[]{"Выбрана текущая вершина: %s", Integer.toString(vertex)}));
        for (DirectedEdge edge : graph.getEdgesForVertex(vertex)) {
            int vertexTo = edge.getTo();
            if (distTo[vertexTo] > (distTo[vertex] + edge.getWeight())) {
                String log = "Была произведена релаксация, метка вершины %s была изменена с "
                        + distTo[vertexTo] + " на " + (distTo[vertex] + edge.getWeight());
                distTo[vertexTo] = distTo[vertex] + edge.getWeight();
                this.edgeTo[vertexTo] = edge;
                if (priorityQueue.contains(new Entry(vertexTo))) {
                    final Iterator<Entry> iterator = priorityQueue.iterator();
                    while (iterator.hasNext()) {
                        final Entry currentElement = iterator.next();
                        if (currentElement.getValue().equals(vertexTo)) {
                            iterator.remove();
                            break;
                        }
                    }
                        priorityQueue.offer(new Entry(distTo[vertexTo], vertexTo));
                } else {
                    priorityQueue.offer(new Entry(distTo[vertexTo], vertexTo));
                }
                steps.add(new MementoShortestWay(vertex, visitedVertex, this.edgeTo, priorityQueue,
                        new String[]{log, Integer.toString(vertexTo)}));
            }
        }
        visitedVertex[vertex] = true;
        steps.add(new MementoShortestWay(-1, visitedVertex, edgeTo, priorityQueue,
                new String[]{"Обаботка вершины %s была закончена", Integer.toString(vertex)}));
    }

    @Override
    public List<MementoShortestWay> buildWay(Digraph graph, int source, int target) {
        steps = new ArrayList<>();
        edgeTo = new DirectedEdge[graph.getVertexCount()];
        distTo = new double[graph.getVertexCount()];
        visitedVertex = new boolean[graph.getVertexCount()];
        priorityQueue = new PriorityQueue<>();
        for (int vertexNumber = 0; vertexNumber < graph.getVertexCount(); vertexNumber++)
            distTo[vertexNumber] = Double.POSITIVE_INFINITY;
        distTo[source] = 0.0;
        priorityQueue.offer(new Entry(distTo[source], source));
        steps.add(new MementoShortestWay(-1, visitedVertex, edgeTo, priorityQueue,
                new String[]{"Начальное состояние алгоритма. В очереди только одна вершина: %s", Integer.toString(source)}));

        while (!priorityQueue.isEmpty()) {
            relax(graph, priorityQueue.poll().getValue());
        }

        return steps;
    }

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

}

