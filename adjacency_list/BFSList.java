package com.mycompany.mavenproject5;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSList {

    public static void bfs(GraphList graph, String start) {

        Queue<String> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        System.out.println("\nBFS Traversal:");

        while (!queue.isEmpty()) {

            String current = queue.poll();
            System.out.print(current + " ");

            for (GraphList.Edge edge : graph.getRoutes()) {

                if (edge.source.equals(current)
                        && !visited.contains(edge.destination)) {

                    visited.add(edge.destination);
                    queue.add(edge.destination);
                }
            }
        }

        System.out.println();
    }

    // SILENT VERSION (for benchmark)
    public static void bfsSilent(GraphList graph, String start) {

        Queue<String> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            for (GraphList.Edge edge : graph.getRoutes()) {

                if (edge.source.equals(current)
                        && !visited.contains(edge.destination)) {

                    visited.add(edge.destination);
                    queue.add(edge.destination);
                }
            }
        }
    }
}