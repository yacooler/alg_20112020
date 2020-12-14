package lesson7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int CNT = 10;
        int EDGES = 2;
        int vertex;
        Random random = new Random();

        Graph graph = new Graph(CNT);
        for (int i = 0; i < CNT; i++) {
            for (int j = 0; j < EDGES; j++) {
                vertex = random.nextInt(CNT);
                if (!graph.edgeExists(i, vertex)) graph.addEdge(i, vertex);
            }
        }

        System.out.println(graph);


        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        System.out.println(bfp.hasPathTo(9));
        System.out.println(bfp.pathTo(9));

    }
}
