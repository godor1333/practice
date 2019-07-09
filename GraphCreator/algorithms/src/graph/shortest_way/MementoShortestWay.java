package graph.shortest_way;

import graph.data_structures.DirectedEdge;
import graph.data_structures.WeightedDigraph;
import graph.data_structures.Entry;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MementoShortestWay {
    private final int currentVertex;
    private final boolean[] processedVertices;
    private final DirectedEdge[] currentWays;
    private final PriorityQueue<Entry> inQueueVertices;
    private final String[] log;

    public MementoShortestWay(int currentVertex,
                              boolean[] processedVertices,
                              DirectedEdge[] currentWays,
                              PriorityQueue<Entry> inQueueVertices,
                              String[] log) {
        this.currentVertex = currentVertex;
        this.processedVertices = processedVertices.clone();
        this.currentWays = currentWays.clone();
        this.inQueueVertices = new PriorityQueue<>(inQueueVertices);
        this.log = log;
    }

    public String getCurrentVertex(WeightedDigraph digraph, String separator) {
        if(currentVertex!=-1)
            return digraph.name(currentVertex)+separator+"\n";
        else
            return "";
    }

    public String getProcessedVertices(WeightedDigraph digraph,String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<processedVertices.length;i++){
            if(processedVertices[i]){
                stringBuilder.append(digraph.name(i)).append(separator).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public String getCurrentWays(WeightedDigraph digraph,String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for(DirectedEdge edge:currentWays){
            if(edge!=null) {
                stringBuilder.append(digraph.name(edge.getFrom()))
                        .append(separator)
                        .append(digraph.name(edge.getTo()))
                        .append(separator)
                        .append(edge.getWeight())
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public String getInQueueVertices(WeightedDigraph digraph,String separator) {
        StringBuilder builder = new StringBuilder();
        for(Entry element: inQueueVertices){
            builder.append(digraph.name(element.getValue())).append(separator).append("\n");
        }
        return builder.toString();
    }

    public String[] getLog() {
        return log;
    }

    @Override
    public String toString() {
        return "MementoShortestWay{" +
                "currentVertex=" + currentVertex +
                ", processedVertices=" + Arrays.toString(processedVertices) +
                ", currentWays=" + Arrays.toString(currentWays) +
                ", inQueueVertices=" + inQueueVertices +
                ", log=" + Arrays.toString(log) +
                '}';
    }
}
