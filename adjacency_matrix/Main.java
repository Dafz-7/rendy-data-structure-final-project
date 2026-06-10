import java.util.Scanner;

public class Main {

public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GraphMatrix graphMatrix =
                new GraphMatrix(10);

        BFSMatrix bfsMatrix =
                new BFSMatrix();

        DijkstraMatrix dijkstraMatrix =
                new DijkstraMatrix();

        
        graphMatrix.addLocation("Jakarta");
        graphMatrix.addLocation("Bandung");
        graphMatrix.addLocation("Bogor");
        graphMatrix.addLocation("Semarang");
        graphMatrix.addLocation("Surabaya");

        
        graphMatrix.addRoad(
                "Jakarta",
                "Bandung",
                150);

        graphMatrix.addRoad(
                "Jakarta",
                "Bogor",
                60);

        graphMatrix.addRoad(
                "Bandung",
                "Semarang",
                300);

        graphMatrix.addRoad(
                "Bogor",
                "Semarang",
                450);

        graphMatrix.addRoad(
                "Semarang",
                "Surabaya",
                350);

        int choice;

        do {

        System.out.println(
                "\n===== INTELLIGENT ROUTE SYSTEM =====");

        System.out.println(
                "1. Display Graph");

        System.out.println(
                "2. BFS Traversal");

        System.out.println(
                "3. Find Shortest Route");

        System.out.println(
                "4. Run Benchmark");
        
        System.out.println(
                "5. Exit");

        System.out.print(
                "Choose Menu: ");

        choice = sc.nextInt();

        switch (choice) {

        case 1:

        graphMatrix.displayGraph();
        break;

        case 2:

        System.out.print("\nEnter Starting City: ");

        String bfsStart = sc.next();

        bfsMatrix.traverse(
                graphMatrix,
                bfsStart);

        break;

        case 3:

        System.out.print("\nEnter Starting City: ");

        String startCity = sc.next();

        System.out.print("Enter Destination City: ");

        String endCity = sc.next();

        dijkstraMatrix.shortestPath(
                graphMatrix,
                startCity,
                endCity);

        break;


        case 4:

        System.out.println("\nProgram Ended.");

        break;

        default:

        System.out.println("\nInvalid Choice.");
}



        } while (choice != 4);

        sc.close();
}
}