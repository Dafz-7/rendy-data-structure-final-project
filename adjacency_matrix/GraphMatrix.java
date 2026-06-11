package adjacency_matrix;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphMatrix {

    private final ArrayList<String> cities;
    private final HashMap<String, Integer> cityIndices;
    private final int[][] matrix;

    private int size;

    public GraphMatrix(int maxCities) {

        cities = new ArrayList<>();
        cityIndices = new HashMap<>();

        matrix = new int[maxCities][maxCities];

        size = 0;
    }

    public void addLocation(String city) {

        if (!cityIndices.containsKey(city)) {

            cities.add(city);

            cityIndices.put(
                    city,
                    size);

            size++;
        }
    }

    public int getIndex(String city) {

        return cityIndices.getOrDefault(
                city,
                -1);
    }

    public void addRoad(
            String city1,
            String city2,
            int distance) {

        int i = getIndex(city1);

        int j = getIndex(city2);

        if (i == -1 || j == -1) {
            return;
        }

        matrix[i][j] = distance;

        matrix[j][i] = distance;
    }

    public void displayGraph() {

        System.out.println(
                "\nAdjacency Matrix:");

        System.out.print(
                "          ");

        for (String city : cities) {

            System.out.printf(
                    "%10s",
                    city);
        }

        System.out.println();

        for (int i = 0; i < size; i++) {

            System.out.printf(
                    "%10s",
                    cities.get(i));

            for (int j = 0; j < size; j++) {

                System.out.printf(
                        "%10d",
                        matrix[i][j]);
            }

            System.out.println();
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public int getSize() {
        return size;
    }
}