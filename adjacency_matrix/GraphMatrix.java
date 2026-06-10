import java.util.ArrayList;

public class GraphMatrix {

    private ArrayList<String> cities;
    private int[][] matrix;
    private int size;

    public GraphMatrix(int maxCities) {

        cities = new ArrayList<>();
        matrix = new int[maxCities][maxCities];
        size = 0;
    }

    public void addLocation(String city) {

        cities.add(city);
        size++;
    }

    public int getIndex(String city) {

        return cities.indexOf(city);
    }

    public void addRoad(String city1,
                        String city2,
                        int distance) {

        int i = getIndex(city1);
        int j = getIndex(city2);

        matrix[i][j] = distance;
        matrix[j][i] = distance;
    }

    public void displayGraph() {

        System.out.println("\nAdjacency Matrix:");

        System.out.print("      ");

        for (String city : cities) {
            System.out.printf("%10s", city);
        }

        System.out.println();

        for (int i = 0; i < size; i++) {

            System.out.printf("%10s", cities.get(i));

            for (int j = 0; j < size; j++) {

                System.out.printf("%10d",
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