package adjacency_list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSList {

    public static void bfs(
            GraphList graph,
            String start) {

        bfsInternal(
                graph,
                start,
                false);
    }

    public static void bfsSilent(
            GraphList graph,
            String start) {

        bfsInternal(
                graph,
                start,
                true);
    }

    private static void bfsInternal(
            GraphList graph,
            String start,
            boolean silent) {

        if (!graph.getLocations()
                .contains(start)) {

            System.out.println(
                    "Starting city not found.");

            return;
        }

        Queue<String> queue = new LinkedList<>();

        HashSet<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        if (!silent) {

            System.out.println(
                    "\nBFS Traversal:");
        }

        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (!silent) {

                System.out.print(
                        current + " ");
            }

            for (GraphList.Edge edge : graph.getNeighbors(current)) {

                if (!visited.contains(
                        edge.getDestination())) {

                    visited.add(
                            edge.getDestination());

                    queue.add(
                            edge.getDestination());
                }
            }
        }

        if (!silent) {

            System.out.println();
        }
    }
}