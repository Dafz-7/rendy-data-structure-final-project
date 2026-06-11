package adjacency_list;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraList {

    static class Node {

        String city;
        int distance;

        public Node(
                String city,
                int distance) {

            this.city = city;
            this.distance = distance;
        }
    }

    public static void shortestPath(
            GraphList graph,
            String start) {

        dijkstraInternal(
                graph,
                start,
                false);
    }

    public static void shortestPathSilent(
            GraphList graph,
            String start) {

        dijkstraInternal(
                graph,
                start,
                true);
    }

    private static void dijkstraInternal(
            GraphList graph,
            String start,
            boolean silent) {

        if (!graph.getLocations()
                .contains(start)) {

            System.out.println(
                    "Starting city not found.");

            return;
        }

        HashMap<String, Integer> distance = new HashMap<>();

        for (String city : graph.getLocations()) {

            distance.put(
                    city,
                    Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(
                        n -> n.distance));

        pq.add(
                new Node(start, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            if (current.distance > distance.get(
                    current.city)) {

                continue;
            }

            for (GraphList.Edge edge : graph.getNeighbors(
                    current.city)) {

                int newDistance = distance.get(
                        current.city)
                        + edge.getDistance();

                if (newDistance < distance.get(
                        edge.getDestination())) {

                    distance.put(
                            edge.getDestination(),
                            newDistance);

                    pq.add(
                            new Node(
                                    edge.getDestination(),
                                    newDistance));
                }
            }
        }

        if (!silent) {

            System.out.println(
                    "\nShortest Distance from "
                            + start);

            for (String city : graph.getLocations()) {

                System.out.println(
                        start
                                + " -> "
                                + city
                                + " = "
                                + distance.get(city)
                                + " km");
            }
        }
    }
}