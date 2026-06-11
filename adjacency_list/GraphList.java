package adjacency_list;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GraphList {

    private final LinkedHashMap<String, ArrayList<Edge>> adjacencyList;

    public GraphList() {
        adjacencyList = new LinkedHashMap<>();
    }

    public void addLocation(String location) {

        adjacencyList.putIfAbsent(
                location,
                new ArrayList<>());
    }

    public void addRoute(
            String source,
            String destination,
            int distance) {

        addLocation(source);
        addLocation(destination);

        adjacencyList.get(source)
                .add(new Edge(
                        destination,
                        distance));

        adjacencyList.get(destination)
                .add(new Edge(
                        source,
                        distance));
    }

    public ArrayList<String> getLocations() {

        return new ArrayList<>(
                adjacencyList.keySet());
    }

    public List<Edge> getNeighbors(
            String city) {

        return adjacencyList.getOrDefault(
                city,
                new ArrayList<>());
    }

    public void displayGraph() {

        System.out.println(
                "\nAdjacency List:");

        for (String city : adjacencyList.keySet()) {

            System.out.print(
                    city + " -> ");

            for (Edge edge : adjacencyList.get(city)) {

                System.out.print(
                        edge.getDestination()
                                + "("
                                + edge.getDistance()
                                + " km) ");
            }

            System.out.println();
        }
    }

    public static class Edge {

        private final String destination;
        private final int distance;

        public Edge(
                String destination,
                int distance) {

            this.destination = destination;

            this.distance = distance;
        }

        public String getDestination() {

            return destination;
        }

        public int getDistance() {

            return distance;
        }
    }
}