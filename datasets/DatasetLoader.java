package datasets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import adjacency_list.GraphList;
import adjacency_matrix.GraphMatrix;

public class DatasetLoader {

    public static void loadCSV(
            String filename,
            GraphList graphList,
            GraphMatrix graphMatrix) {

        try (BufferedReader br = new BufferedReader(
                new FileReader(filename))) {

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String source = data[0];

                String destination = data[1];

                int distance = Integer.parseInt(
                        data[2]);

                graphList.addLocation(
                        source);

                graphList.addLocation(
                        destination);

                graphMatrix.addLocation(
                        source);

                graphMatrix.addLocation(
                        destination);

                graphList.addRoute(
                        source,
                        destination,
                        distance);

                graphMatrix.addRoad(
                        source,
                        destination,
                        distance);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}