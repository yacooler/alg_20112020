package lesson7;

import java.util.LinkedList;

public abstract class GraphPaths {
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int startVertex;
    protected Graph graph;

    public GraphPaths(Graph graph, int startVertex) {
        this.startVertex = startVertex;
        this.graph = graph;
        edgeTo = new int[graph.getVertexCount()];
        marked = new boolean[graph.getVertexCount()];
        calc(startVertex);
    }

    protected abstract void calc(int currentVertex);

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != startVertex) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

}