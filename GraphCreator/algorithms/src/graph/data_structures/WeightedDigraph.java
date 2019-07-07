package graph.data_structures;
import graph.shortest_way.MementoShortestWay;
import graph.shortest_way.ShortestWayAlgorithm;

import java.util.*;
import java.util.stream.Stream;

public class WeightedDigraph {
    private Digraph graph;
    private Map<String, Integer> vertexNameOfNumber;

    public WeightedDigraph(String stream, String separator) {
        final List<List<String>> graphStringRepresentation = prepareGraphStringRepresentation(stream, separator);
        final int graphSize = graphStringRepresentation.stream().map(List::size).reduce(Integer::sum).orElse(0);
        buildGraphFromStringRepresentation(graphStringRepresentation, graphSize);
    }

    private List<List<String>> prepareGraphStringRepresentation(String stream, String separator) {
        final List<List<String>> graphStringRepresentation = new ArrayList<>();
        final Scanner scanner = new Scanner(stream);
        while (scanner.hasNext()) {
            List<String> stringGraph = Arrays.asList(scanner.nextLine().split(String.format("[\\%s]", separator)));
            graphStringRepresentation.add(stringGraph);
        }
        return graphStringRepresentation;
    }

    private void buildGraphFromStringRepresentation(List<List<String>> graphStringRepresentation, int graphSize) {
        graph = new Digraph(graphSize);
        vertexNameOfNumber = new HashMap<>();
        for (List<String> graphLine : graphStringRepresentation) {
            final String sourceVertexName = graphLine.get(0);
            if (graphLine.size() > 1) {
                final String targetVertexName = graphLine.get(1);

                vertexNameOfNumber.putIfAbsent(sourceVertexName, vertexNameOfNumber.size());
                vertexNameOfNumber.putIfAbsent(targetVertexName, vertexNameOfNumber.size());

                final int sourceVertexNumber = vertexNameOfNumber.get(sourceVertexName);
                final int targetVertexNumber = vertexNameOfNumber.get(targetVertexName);
                final double weight = Double.parseDouble(graphLine.get(2));
                graph.addEdge(new DirectedEdge(sourceVertexNumber, targetVertexNumber, weight));
            } else {
                vertexNameOfNumber.putIfAbsent(sourceVertexName, vertexNameOfNumber.size());
            }
        }
    }

    public int index(String s) {
        return vertexNameOfNumber.get(s);
    }

    public String name(int vertex) {
        return new ArrayList<>(vertexNameOfNumber.keySet()).stream()
                .filter(el -> vertexNameOfNumber.get(el)
                        .equals(vertex))
                .findFirst()
                .get();
    }

    public List<MementoShortestWay> shortestWay(String source, String target, ShortestWayAlgorithm algorithm) {
        return algorithm.buildWay(graph, index(source), index(target));
    }
}
