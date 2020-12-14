package lesson7;

import java.util.LinkedList;

public class DepthFirstPaths extends GraphPaths{

    public DepthFirstPaths(Graph graph, int startVertex) {
        super(graph, startVertex);
    }

    @Override
    protected void calc(int currentVertex) {
        marked[currentVertex] = true;
        for (int w : graph.getAdjList(currentVertex)) {
            if(!marked[w]){
                edgeTo[w] = currentVertex;
                calc(w);
            }
        }
    }
}
