package adjacency_matrix;

public class BenchmarkMatrix {

    public static void runBenchmark(
            GraphMatrix graph,
            BFSMatrix bfs,
            DijkstraMatrix dijkstra) {

        if (graph.getSize() == 0) {

            System.out.println(
                    "Graph is empty.");

            return;
        }

        int iterations = 100;

        String startCity = graph.getCities().get(0);

        String endCity = graph.getCities().get(
                graph.getSize() - 1);

        System.out.println(
                "\n--- ADJACENCY MATRIX RESULTS ---");

        for (int run = 1; run <= 3; run++) {

            System.out.println(
                    "\n===== ADJACENCY MATRIX - RUN "
                            + run
                            + " =====");

            long bfsStart = System.nanoTime();

            for (int i = 0; i < iterations; i++) {

                bfs.traverse(
                        graph,
                        startCity,
                        true);
            }

            long bfsEnd = System.nanoTime();

            long dijkstraStart = System.nanoTime();

            for (int i = 0; i < iterations; i++) {

                dijkstra.shortestPath(
                        graph,
                        startCity,
                        endCity,
                        true);
            }

            long dijkstraEnd = System.nanoTime();

            double bfsMs = (bfsEnd - bfsStart)
                    / 1_000_000.0;

            double dijkstraMs = (dijkstraEnd - dijkstraStart)
                    / 1_000_000.0;

            System.out.printf(
                    "BFS (%d runs): %.3f ms%n",
                    iterations,
                    bfsMs);

            System.out.printf(
                    "Dijkstra (%d runs): %.3f ms%n",
                    iterations,
                    dijkstraMs);

            System.out.printf(
                    "Average BFS: %.6f ms/run%n",
                    bfsMs / iterations);

            System.out.printf(
                    "Average Dijkstra: %.6f ms/run%n",
                    dijkstraMs / iterations);
        }
    }
}