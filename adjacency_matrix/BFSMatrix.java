package adjacency_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFSMatrix {

    public void traverse(
            GraphMatrix graph,
            String startCity) {

        traverse(
                graph,
                startCity,
                false);
    }

    public void traverse(
            GraphMatrix graph,
            String startCity,
            boolean silent) {

        int start = graph.getIndex(startCity);

        if (start == -1) {
            return;
        }

        int size = graph.getSize();

        int[][] matrix = graph.getMatrix();

        boolean[] visited = new boolean[size];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        if (!silent) {

            System.out.println(
                    "\nBFS Traversal:");
        }

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (!silent) {

                System.out.println(
                        "Visited: "
                                + graph.getCities()
                                        .get(current));
            }

            for (int i = 0; i < size; i++) {

                if (matrix[current][i] != 0
                        && !visited[i]) {

                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}