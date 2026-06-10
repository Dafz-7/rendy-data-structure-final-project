package com.mycompany.mavenproject5;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraList {

    static class Node {
        String city;
        int distance;

        public Node(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

    public static void shortestPath(GraphList graph, String start) {

        HashMap<String, Integer> distance = new HashMap<>();

        for (String city : graph.getLocations()) {
            distance.put(city, Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            for (GraphList.Edge edge : graph.getRoutes()) {

                if (edge.source.equals(current.city)) {

                    int newDistance =
                            distance.get(current.city)
                                    + edge.distance;

                    if (newDistance < distance.get(edge.destination)) {

                        distance.put(edge.destination, newDistance);

                        pq.add(new Node(edge.destination, newDistance));
                    }
                }
            }
        }

        System.out.println("\nShortest Distance from " + start);

        for (String city : graph.getLocations()) {
            System.out.println(start + " -> " + city + " = " +
                    distance.get(city) + " km");
        }
    }

    // SILENT VERSION (for benchmark)
    public static void shortestPathSilent(GraphList graph, String start) {

        HashMap<String, Integer> distance = new HashMap<>();

        for (String city : graph.getLocations()) {
            distance.put(city, Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            for (GraphList.Edge edge : graph.getRoutes()) {

                if (edge.source.equals(current.city)) {

                    int newDistance =
                            distance.get(current.city)
                                    + edge.distance;

                    if (newDistance < distance.get(edge.destination)) {

                        distance.put(edge.destination, newDistance);

                        pq.add(new Node(edge.destination, newDistance));
                    }
                }
            }
        }
    }
}