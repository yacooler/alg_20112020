package lesson7;

import java.util.LinkedList;

public class BreadthFirstPaths extends GraphPaths{

    public BreadthFirstPaths(Graph graph, int startVertex) {
        super(graph, startVertex);
    }

    @Override
    protected void calc(int currentVertex) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(currentVertex);
        marked[currentVertex] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : graph.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }

}
