package lesson7;

import java.util.LinkedList;
import java.util.StringJoiner;

public class Graph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Количество вершин должно быть натуральным числом");
        }
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public boolean edgeExists(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        if (adjList[v1].isEmpty()) return false;
        return adjList[v1].contains(v2);
    }

    public LinkedList<Integer> getAdjList(int vertex) {
        return (LinkedList<Integer>) adjList[vertex].clone();
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        adjList[v1].add(v2);
        edgeCount++;
        if (v1 == v2) {
            return;
        }
        adjList[v2].add(v1);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Graph\n");
        for (int i = 0; i < adjList.length; i++) {
            sb.append("V(").append(i).append(") = [");
            if (!adjList[i].isEmpty()) {
                for (int j = 0; j < adjList[i].size(); j++) {
                    sb.append(adjList[i].get(j));
                    if (j + 1 < adjList[i].size()) sb.append(", ");
                }
            }
            sb.append("]\n");
        }

        return sb.toString();
    }
}
