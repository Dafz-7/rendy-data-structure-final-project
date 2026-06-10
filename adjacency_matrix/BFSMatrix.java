import java.util.LinkedList;
import java.util.Queue;

public class BFSMatrix {

public void traverse(GraphMatrix graph,
                        String startCity) {

        int start =
                graph.getIndex(startCity);

        boolean[] visited =
                new boolean[graph.getSize()];

        Queue<Integer> queue =
                new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println(
                "\nBFS Traversal:"
        );

        while (!queue.isEmpty()) {

        int current =
                queue.poll();

        System.out.println(
                "Visited: "
                + graph.getCities()
                        .get(current)
        );

        for (int i = 0;
                i < graph.getSize();
                i++) {

                if (graph.getMatrix()
                        [current][i] != 0
                        && !visited[i]) {

                visited[i] = true;
                queue.add(i);
                }
        }
        }
}
}