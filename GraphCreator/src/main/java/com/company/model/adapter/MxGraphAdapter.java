package com.company.model.adapter;


import com.company.model.algorithms.MementoShortestWayView;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import graph.data_structures.DirectedEdge;
import graph.data_structures.WeightedDigraph;
import graph.shortest_way.Dijkstra;
import graph.shortest_way.MementoShortestWay;
import graph.shortest_way.ShortestWayAlgorithm;

import java.util.*;
import java.util.function.Consumer;

import static com.company.Constants.SEPARATOR;
import static com.company.Constants.Algorithms.*;

public class MxGraphAdapter implements GraphAdapter {

    private String convertFromMxGraphToGraph(mxGraph graph) {
        Set<String> vertex = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (Object e : graph.getChildEdges(graph.getDefaultParent())) {
            mxCell edge = (mxCell) e;
            String source = (String) edge.getSource().getValue();
            String target = (String) edge.getTarget().getValue();
            vertex.add(source);
            vertex.add(target);
            sb.append(source).append(SEPARATOR).append(target).append(SEPARATOR).append(edge.getValue()).append("\n");
        }
        for (Object v : graph.getChildVertices(graph.getDefaultParent())) {
            mxCell ver = (mxCell) v;
            if (!vertex.contains(ver.getValue())) {
                vertex.add((String) ver.getValue());
                sb.append((String) ver.getValue()).append(SEPARATOR).append("\n");
            }
        }
        return sb.toString();
    }

    private Object[] convertFromGraphToMxGraph(mxGraph graph, String subgraph) {
        List<mxCell> cells = new ArrayList<>();
        Scanner scanner = new Scanner(subgraph);
        while (scanner.hasNextLine()) {
            String[] a = scanner.nextLine().split(String.format("[\\%s]", SEPARATOR));
            if (a.length == 1) {
                for (Object v : graph.getChildVertices(graph.getDefaultParent())) {
                    if (((mxCell) v).getValue().equals(a[0])) {
                        cells.add((mxCell) v);
                    }
                }
            } else {
                for (Object e : graph.getChildEdges(graph.getDefaultParent())) {
                    String source = (String) ((mxCell) e).getSource().getValue();
                    String target = (String) ((mxCell) e).getTarget().getValue();
                    if (source.equals(a[0]) && target.equals(a[1])) {
                        cells.add((mxCell) e);
                        cells.add((mxCell) ((mxCell) e).getSource());
                        cells.add((mxCell) ((mxCell) e).getTarget());
                    }
                }
            }
        }
        return cells.isEmpty() ? null : cells.toArray();
    }

    private List<MementoShortestWayView> convertToView(mxGraph graph, WeightedDigraph digraph, List<MementoShortestWay> mementos) {
        List<MementoShortestWayView> mementosView = new ArrayList<>();
        for (MementoShortestWay memento : mementos) {
            Object[] currentVertex = convertFromGraphToMxGraph(graph, memento.getCurrentVertex(digraph, SEPARATOR));
            Object[] processedVertices = convertFromGraphToMxGraph(graph, memento.getProcessedVertices(digraph, SEPARATOR));
            Object[] currentWays = convertFromGraphToMxGraph(graph, memento.getCurrentWays(digraph, SEPARATOR));
            Object[] inQueueVertices = convertFromGraphToMxGraph(graph, memento.getInQueueVertices(digraph, SEPARATOR));
            String log= String.format(memento.getLog()[0], digraph.name(Integer.parseInt(memento.getLog()[1])));
            if (currentVertex != null)
                mementosView.add(new MementoShortestWayView(currentVertex[0], processedVertices, currentWays, inQueueVertices, null, log));
            else
                mementosView.add(new MementoShortestWayView(null, processedVertices, currentWays, inQueueVertices, null, log));
        }
        return mementosView;
    }

    @Override
    public void shortestWay(String alg, Object gr, Object s, Object t, Consumer<List<MementoShortestWayView>> callbackEnd) {
        new Thread(() -> {
            WeightedDigraph digraph = new WeightedDigraph(convertFromMxGraphToGraph((mxGraph) gr), SEPARATOR);
            List<MementoShortestWayView> mementosView = null;
            ShortestWayAlgorithm algorithm = null;
            String sourceStr = (String) ((mxCell) s).getValue();
            String targetStr = (String) ((mxCell) t).getValue();
            switch (alg) {
                case DIJKSTRA:
                    algorithm = new Dijkstra();
                    mementosView = convertToView((mxGraph) gr, digraph, digraph.shortestWay(sourceStr, targetStr, algorithm));
                    break;
                case FORD_BELLMAN:

                    break;
                case ASTAR:

                    break;
            }

            if (algorithm != null) {
                StringBuilder sb = new StringBuilder();
                Object[] answer;
                String log;
                if (algorithm.hasPathTo(digraph.index(targetStr))) {
                    for (DirectedEdge e : algorithm.pathTo(digraph.index(targetStr))) {
                        sb.append(digraph.name(e.getFrom()))
                                .append(SEPARATOR)
                                .append(digraph.name(e.getTo()))
                                .append(SEPARATOR).append(e.getWeight())
                                .append("\n");
                    }
                    log = "Путь из вершины " + sourceStr + " в вершину " + targetStr + " найден \n" + sb.toString();
                    answer = convertFromGraphToMxGraph((mxGraph) gr, sb.toString());
                } else {
                    answer = null;
                    log = "Пути из вершины " + sourceStr + " в вершину " + targetStr + " не существует \n";
                }
                mementosView.add(new MementoShortestWayView(null, null, null, null,
                        answer, log));
            }
            callbackEnd.accept(mementosView);
        }).start();
    }
}
