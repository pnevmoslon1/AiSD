public class FloydWarshall {
    final static int INF = 99999999, V = 4;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;

        // Инициализируем матрицу расстояний точной копией графа и значениями INF для несмежных вершин
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // Алгоритм Флойда-Уоршалла
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    // Если путь через вершину k короче текущего, обновляем значение
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Выводим кратчайшие расстояния между всеми парами вершин
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("Кратчайшие расстояния между всеми парами вершин:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}