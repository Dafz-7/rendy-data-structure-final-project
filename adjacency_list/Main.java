package com.mycompany.mavenproject5;
public class Main {

    public static void main(String[] args) {

        GraphList graph = new GraphList();

        graph.addLocation("Jakarta");
        graph.addLocation("Bandung");
        graph.addLocation("Bogor");
        graph.addLocation("Semarang");
        graph.addLocation("Surabaya");

        graph.addRoute("Jakarta", "Bogor", 60);
        graph.addRoute("Jakarta", "Bandung", 150);
        graph.addRoute("Bogor", "Semarang", 420);
        graph.addRoute("Bandung", "Semarang", 450);
        graph.addRoute("Semarang", "Surabaya", 350);
        graph.addRoute("Bandung", "Surabaya", 780);

        graph.displayGraph();

        // RUN BFS (optional)
        BFSList.bfs(graph, "Jakarta");

        // RUN DIJKSTRA (optional)
        DijkstraList.shortestPath(graph, "Jakarta");

        // RUN BENCHMARK
        BenchmarkList.runBenchmark(graph);
    }
}