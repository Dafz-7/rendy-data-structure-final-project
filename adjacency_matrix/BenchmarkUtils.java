package com.mycompany.mavenproject6;

public class BenchmarkUtils {

    public static void runBenchmark(
            GraphMatrix graph,
            BFSMatrix bfs,
            DijkstraMatrix dijkstra) {

        int iterations = 10000;

        // Warmup runs quietly
        for (int i = 0; i < 2000; i++) {
            bfs.traverse(graph, "Jakarta", true);
            dijkstra.shortestPath(graph, "Jakarta", "Surabaya", true);
        }

        // Benchmark BFS
        long bfsStart = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bfs.traverse(graph, "Jakarta", true);
        }
        long bfsEnd = System.nanoTime();

        // Benchmark Dijkstra
        long dijkstraStart = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            dijkstra.shortestPath(graph, "Jakarta", "Surabaya", true);
        }
        long dijkstraEnd = System.nanoTime();

        double bfsMs = (bfsEnd - bfsStart) / 1_000_000.0;
        double dijkstraMs = (dijkstraEnd - dijkstraStart) / 1_000_000.0;

        System.out.println("\n===== BENCHMARK =====");
        System.out.printf("BFS (%d runs): %.3f ms%n", iterations, bfsMs);
        System.out.printf("Dijkstra (%d runs): %.3f ms%n", iterations, dijkstraMs);
        System.out.printf("Average BFS: %.6f ms/run%n", bfsMs / iterations);
        System.out.printf("Average Dijkstra: %.6f ms/run%n", dijkstraMs / iterations);
    }
}