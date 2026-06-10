package com.mycompany.mavenproject5;
import java.util.ArrayList;

public class GraphList {

    private final ArrayList<String> locations;
    private final ArrayList<Edge> routes;

    public GraphList() {
        locations = new ArrayList<>();
        routes = new ArrayList<>();
    }

    public void addLocation(String location) {
        locations.add(location);
    }

    public void addRoute(String source, String destination, int distance) {
        routes.add(new Edge(source, destination, distance));
        routes.add(new Edge(destination, source, distance));
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public ArrayList<Edge> getRoutes() {
        return routes;
    }

    public void displayGraph() {
        System.out.println("Route Planning Graph:");

        for (String location : locations) {
            System.out.print(location + " -> ");

            for (Edge edge : routes) {
                if (edge.source.equals(location)) {
                    System.out.print(edge.destination +
                            "(" + edge.distance + " km) ");
                }
            }

            System.out.println();
        }
    }

    public static class Edge {
        String source;
        String destination;
        int distance;

        public Edge(String source, String destination, int distance) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
        }
    }
}