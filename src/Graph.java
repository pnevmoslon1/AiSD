import java.util.*;

public class Graph {
    private int V; // Количество вершин
    private int[][] adjMatrix; // Матрица смежности

    // Конструктор
    Graph(int v) {
        V = v;
        adjMatrix = new int[v][v];
    }

    // Функция для добавления ребра в граф
    void addEdge(int v, int w) {
        adjMatrix[v][w] = 1;
        adjMatrix[w][v] = 1; // Если граф неориентированный
    }

    // Функция для выполнения BFS
    void BFS(int s) {
        // Помечаем все вершины как непосещенные
        boolean[] visited = new boolean[V];

        // Создаем очередь для BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Помечаем текущую вершину как посещенную и помещаем ее в очередь
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Извлекаем вершину из очереди и печатаем ее
            s = queue.poll();
            System.out.print(s + " ");

            // Получаем все соседние вершины непосещенные вершины и помещаем их в очередь
            for (int i = 0; i < V; i++) {
                if (adjMatrix[s][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}