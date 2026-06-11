package main;

import java.util.Scanner;

import datasets.DatasetLoader;

import adjacency_list.GraphList;
import adjacency_list.BenchmarkList;

import adjacency_matrix.GraphMatrix;
import adjacency_matrix.BFSMatrix;
import adjacency_matrix.DijkstraMatrix;
import adjacency_matrix.BenchmarkMatrix;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        intelligentRouteSystem();

        System.out.print(
                "\nRun Benchmark Tests? (Y/N): ");

        String choice = sc.nextLine();

        if (!choice.equalsIgnoreCase("Y")) {

            System.out.println(
                    "\nProgram Ended.");

            return;
        }

        System.out.println(
                "\n=================================");
        System.out.println(
                "SPARSE GRAPH BENCHMARKS");
        System.out.println(
                "=================================");

        runDataset(
                "datasets/small.csv",
                100);

        runDataset(
                "datasets/medium.csv",
                500);

        runDataset(
                "datasets/large.csv",
                1000);

        System.out.println(
                "\n=================================");
        System.out.println(
                "DENSE GRAPH BENCHMARKS");
        System.out.println(
                "=================================");

        runDataset(
                "datasets/dense_small.csv",
                100);

        runDataset(
                "datasets/dense_medium.csv",
                500);

        runDataset(
                "datasets/dense_large.csv",
                1000);

        System.out.println(
                "\nAll Benchmarks Completed.");
    }

    private static void intelligentRouteSystem() {

        GraphMatrix graph = new GraphMatrix(100);

        DatasetLoader.loadCSV(
                "datasets/sparse_small.csv",
                new GraphList(),
                graph);

        System.out.println(
                "\n=================================");

        System.out.println(
                "INTELLIGENT ROUTE SYSTEM");

        System.out.println(
                "=================================");

        System.out.println(
                "\nAvailable Cities:");

        for (String city : graph.getCities()) {

            System.out.print(
                    city + " ");
        }

        System.out.println();

        System.out.print(
                "\nEnter Start City: ");

        String start = sc.nextLine();

        System.out.print(
                "Enter Destination City: ");

        String destination = sc.nextLine();

        DijkstraMatrix dijkstra = new DijkstraMatrix();

        dijkstra.shortestPath(
                graph,
                start,
                destination);

        System.out.println(
                "\n=================================");
    }

    private static void runDataset(
            String file,
            int maxCities) {

        System.out.println(
                "\n====================");
        System.out.println(
                "Dataset: " + file);
        System.out.println(
                "====================");

        Runtime runtime = Runtime.getRuntime();

        /*
         * =========================
         * ADJACENCY LIST MEMORY
         * =========================
         */

        runtime.gc();

        long listBefore = runtime.totalMemory()
                - runtime.freeMemory();

        GraphList tempList = new GraphList();

        DatasetLoader.loadCSV(
                file,
                tempList,
                new GraphMatrix(maxCities));

        runtime.gc();

        long listAfter = runtime.totalMemory()
                - runtime.freeMemory();

        long listMemory = listAfter - listBefore;

        /*
         * =========================
         * ADJACENCY MATRIX MEMORY
         * =========================
         */

        runtime.gc();

        long matrixBefore = runtime.totalMemory()
                - runtime.freeMemory();

        GraphMatrix tempMatrix = new GraphMatrix(maxCities);

        DatasetLoader.loadCSV(
                file,
                new GraphList(),
                tempMatrix);

        runtime.gc();

        long matrixAfter = runtime.totalMemory()
                - runtime.freeMemory();

        long matrixMemory = matrixAfter - matrixBefore;

        System.out.println(
                "Adjacency List Memory: "
                        + formatMemory(
                                listMemory));

        System.out.println(
                "Adjacency Matrix Memory: "
                        + formatMemory(
                                matrixMemory));

        /*
         * =========================
         * ACTUAL GRAPH CREATION
         * =========================
         */

        GraphList graphList = new GraphList();

        GraphMatrix graphMatrix = new GraphMatrix(maxCities);

        DatasetLoader.loadCSV(
                file,
                graphList,
                graphMatrix);

        System.out.println(
                "Number of Cities: "
                        + graphMatrix.getSize());

        /*
         * =========================
         * BENCHMARKS
         * =========================
         */

        BenchmarkList.runBenchmark(
                graphList);

        BenchmarkMatrix.runBenchmark(
                graphMatrix,
                new BFSMatrix(),
                new DijkstraMatrix());

        System.out.println(
                "\n=================================");
    }

    private static String formatMemory(
            long bytes) {

        double value = bytes;

        String[] units = {
                "Bytes",
                "KB",
                "MB",
                "GB"
        };

        int unitIndex = 0;

        while (value >= 1024
                && unitIndex < units.length - 1) {

            value /= 1024;
            unitIndex++;
        }

        return String.format(
                "%.2f %s",
                value,
                units[unitIndex]);
    }
}