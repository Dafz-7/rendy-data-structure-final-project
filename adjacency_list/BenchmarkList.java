package com.mycompany.mavenproject5;
public class BenchmarkList {

    public static void runBenchmark(GraphList graph) {

        int iterations = 10000;

        // WARM-UP
        for (int i = 0; i < 2000; i++) {
            BFSList.bfsSilent(graph, "Jakarta");
            DijkstraList.shortestPathSilent(graph, "Jakarta");
        }

        // BFS BENCHMARK
        long bfsStart = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            BFSList.bfsSilent(graph, "Jakarta");
        }

        long bfsEnd = System.nanoTime();

        // DIJKSTRA BENCHMARK
        long dijkstraStart = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            DijkstraList.shortestPathSilent(graph, "Jakarta");
        }

        long dijkstraEnd = System.nanoTime();

        double bfsMs = (bfsEnd - bfsStart) / 1_000_000.0;
        double dijkstraMs = (dijkstraEnd - dijkstraStart) / 1_000_000.0;

        System.out.println("\n===== BENCHMARK =====");

        System.out.printf("BFS (10000 runs): %.3f ms%n", bfsMs);
        System.out.printf("Dijkstra (10000 runs): %.3f ms%n", dijkstraMs);

        System.out.printf("Average BFS: %.6f ms/run%n", bfsMs / iterations);
        System.out.printf("Average Dijkstra: %.6f ms/run%n", dijkstraMs / iterations);
    }
}