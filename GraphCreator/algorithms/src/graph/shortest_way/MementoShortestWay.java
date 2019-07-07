package graph.shortest_way;

import graph.data_structures.DirectedEdge;
import graph.data_structures.WeightedDigraph;
import model.Entry;

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
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<processedVertices.length;i++){
            if(processedVertices[i]){
                sb.append(digraph.name(i)).append(separator).append("\n");
            }
        }
        return sb.toString();
    }

    public String getCurrentWays(WeightedDigraph digraph,String separator) {
        StringBuilder sb = new StringBuilder();
        for(DirectedEdge e:currentWays){
            if(e!=null) {
                sb.append(digraph.name(e.getFrom()))
                        .append(separator)
                        .append(digraph.name(e.getTo()))
                        .append(separator)
                        .append(e.getWeight())
                        .append("\n");
            }
        }
        return sb.toString();
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
}
