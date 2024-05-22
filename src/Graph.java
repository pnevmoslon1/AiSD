import java.util.*;

public class Graph {
    private int V;
    private int[][] adjMatrix;

    Graph(int v) {
        V = v;
        adjMatrix = new int[v][v];
    }


    void addEdge(int v, int w) {
        adjMatrix[v][w] = 1;
        adjMatrix[w][v] = 1;
    }


    void BFS(int s) {
        boolean[] visited = new boolean[V];


        LinkedList<Integer> queue = new LinkedList<>();


        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");


            for (int i = 0; i < V; i++) {
                if (adjMatrix[s][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}