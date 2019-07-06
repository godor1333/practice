package shortest.way;

import model.graph.DirectedEdge;
import model.graph.Entry;
import model.graph.WeightedDigraph;

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
            return digraph.getVertexName(currentVertex)+separator+"\n";
        else
            return "";
    }

    public String getProcessedVertices(WeightedDigraph digraph,String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<processedVertices.length;i++){
            if(processedVertices[i]){
                stringBuilder.append(digraph.getVertexName(i)).append(separator).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public String getCurrentWays(WeightedDigraph digraph,String separator) {
       return null;
    }

    public String getInQueueVertices(WeightedDigraph digraph, String separator) {
     return null;
    }

    public String[] getLog() {
        return log;
    }
}
