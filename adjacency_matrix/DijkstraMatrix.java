package adjacency_matrix;

import java.util.Arrays;

public class DijkstraMatrix {

    public void shortestPath(
            GraphMatrix graph,
            String startCity,
            String endCity) {

        shortestPath(
                graph,
                startCity,
                endCity,
                false);
    }

    public void shortestPath(
            GraphMatrix graph,
            String startCity,
            String endCity,
            boolean silent) {

        int n = graph.getSize();

        int[][] matrix = graph.getMatrix();

        int[] distance = new int[n];

        boolean[] visited = new boolean[n];

        Arrays.fill(
                distance,
                Integer.MAX_VALUE);

        int start = graph.getIndex(startCity);

        int end = graph.getIndex(endCity);

        if (start == -1 || end == -1) {
            return;
        }

        distance[start] = 0;

        for (int count = 0; count < n - 1; count++) {

            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {

                if (!visited[i]
                        && distance[i] < min) {

                    min = distance[i];
                    u = i;
                }
            }

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {

                if (!visited[v]
                        && matrix[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u]
                                + matrix[u][v] < distance[v]) {

                    distance[v] = distance[u]
                            + matrix[u][v];
                }
            }
        }

        if (!silent) {

            System.out.println(
                    "\nShortest Distance: "
                            + distance[end]);
        }
    }
}