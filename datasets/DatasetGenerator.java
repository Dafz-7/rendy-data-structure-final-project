package datasets;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

public class DatasetGenerator {

    public static void generate(
            String filename,
            int vertices,
            int edges) throws IOException {

        Random rand = new Random();

        FileWriter writer = new FileWriter(filename);

        writer.write(
                "source,destination,distance\n");

        HashSet<String> usedEdges = new HashSet<>();

        // Ensure graph connectivity
        for (int i = 1; i < vertices; i++) {

            String source = "City" + i;

            String destination = "City" + (i + 1);

            int distance = rand.nextInt(1000) + 1;

            writer.write(
                    source + ","
                            + destination + ","
                            + distance + "\n");

            usedEdges.add(
                    source + "-"
                            + destination);

            usedEdges.add(
                    destination + "-"
                            + source);
        }

        int currentEdges = vertices - 1;

        while (currentEdges < edges) {

            int sourceId = rand.nextInt(vertices) + 1;

            int destinationId = rand.nextInt(vertices) + 1;

            if (sourceId == destinationId) {
                continue;
            }

            String source = "City" + sourceId;

            String destination = "City" + destinationId;

            String edgeKey = source + "-"
                    + destination;

            if (usedEdges.contains(
                    edgeKey)) {

                continue;
            }

            int distance = rand.nextInt(1000) + 1;

            writer.write(
                    source + ","
                            + destination + ","
                            + distance + "\n");

            usedEdges.add(
                    source + "-"
                            + destination);

            usedEdges.add(
                    destination + "-"
                            + source);

            currentEdges++;
        }

        writer.close();

        System.out.println(
                filename
                        + " generated successfully.");
    }

    public static void main(
            String[] args)
            throws IOException {

        // Sparse
        generate(
                "small.csv",
                100,
                300);

        generate(
                "medium.csv",
                500,
                1500);

        generate(
                "large.csv",
                1000,
                3000);

        // Dense
        generate(
                "dense_small.csv",
                100,
                4000);

        generate(
                "dense_medium.csv",
                500,
                50000);

        generate(
                "dense_large.csv",
                1000,
                200000);
    }
}