package com.mycompany.mavenproject6;

import java.util.Arrays;

public class DijkstraMatrix {

    public int shortestPath(GraphMatrix graph, String startCity, String endCity, boolean silent) {
        int n = graph.getSize();
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        int[] previous = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);

        int start = graph.getIndex(startCity);
        int end = graph.getIndex(endCity);

        distance[start] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }

            if (u == -1) break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v]
                        && graph.getMatrix()[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph.getMatrix()[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph.getMatrix()[u][v];
                    previous[v] = u;
                }
            }
        }

        // Only prints manually from the menu choice
        if (!silent) {
            System.out.println("\nShortest Distance: " + distance[end]);
        }

        return distance[end];
    }
}