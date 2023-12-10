import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class DroneZone {
    static char[][] grid;
    static int rows, cols;
    static void initializeGrid(int rows, int columns) {
        grid = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = '-';
            }
        }
    }

    static void placeDrones(int[] droneX, int[] droneY) {
        for (int i = 0; i < droneX.length; i++) {
            grid[droneX[i]][droneY[i]] = 'D';
        }
    }

    static void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void findTarget(int targetX, int targetY, int[] droneX, int[] droneY , int nearestDrone, int totalRows, int totalColumns) {
        if((targetX<0 || targetX>=totalRows) || (targetY<0 || targetY>=totalColumns)){
            System.out.println("But the target is out of reach");
            return;
        }
        placeDrones(droneX, droneY);
        int droneCurrentX = droneX[nearestDrone];
        int droneCurrenty = droneY[nearestDrone];
        HashMap<Integer, ArrayList<Integer>> path = new HashMap<>();
        int totalSteps = 0;

        while (droneCurrentX != targetX || droneCurrenty != targetY) {
            // Move towards the target
            if (droneCurrentX < targetX) {
                droneCurrentX++;
                ArrayList<Integer> pathSteps = new ArrayList<>();
                pathSteps.add(droneCurrentX);
                pathSteps.add(droneCurrenty);
                path.put(totalSteps,pathSteps);
                totalSteps++;
            }
            else if (droneCurrentX > targetX) {
                droneCurrentX--;
                ArrayList<Integer> pathSteps = new ArrayList<>();
                pathSteps.add(droneCurrentX);
                pathSteps.add(droneCurrenty);
                path.put(totalSteps,pathSteps);
                totalSteps++;
            }

            if (droneCurrenty < targetY) {
                droneCurrenty++;
                ArrayList<Integer> pathSteps = new ArrayList<>();
                pathSteps.add(droneCurrentX);
                pathSteps.add(droneCurrenty);
                path.put(totalSteps,pathSteps);
                totalSteps++;

            }
            else if (droneCurrenty > targetY) {
                droneCurrenty--;
                ArrayList<Integer> pathSteps = new ArrayList<>();
                pathSteps.add(droneCurrentX);
                pathSteps.add(droneCurrenty);
                path.put(totalSteps,pathSteps);
                totalSteps++;
            }
            // Check if the drone has reached the target
            if (droneCurrentX == targetX && droneCurrenty == targetY) {
                System.out.println("Target found at position (" + targetX + ", " + targetY + ") by drone at ("
                        + droneX[nearestDrone] + ", " + droneY[nearestDrone] + ")!");
                System.out.println("Path is as follows :");

                for (Map.Entry<Integer, ArrayList<Integer>> mapElement : path.entrySet()) {

                    ArrayList<Integer> value = (mapElement.getValue());
                    System.out.println(value.get(0) + " " + value.get(1));
                }
                printGrid();
                return; // Stop the loop once the target is found
            }
        }
    }
    static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    // Find the drone with the minimum distance to the target
    static int findNearestDrone(int targetX, int targetY, int[] droneX, int[] droneY) {
        int minDistance = Integer.MAX_VALUE;
        int nearestDrone = -1;

        for (int i = 0; i < droneX.length; i++) {
            int distance = (int) calculateDistance(droneX[i], droneY[i], targetX, targetY);
            if (distance < minDistance) {
                minDistance = distance;
                nearestDrone = i;
            }
        }

        return nearestDrone;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the grid: ");
        int totalRows = scanner.nextInt();
        System.out.print("Enter the number of columns in the grid: ");
        int totalColumns = scanner.nextInt();

        initializeGrid(totalRows, totalColumns);

        int[] droneX = new int[4];
        int[] droneY = new int[4];

        for (int i = 0; i < 4; i++) {
            System.out.println("Print the position of the drone: x,y : ");
            droneX[i] = scanner.nextInt();
            droneY[i] = scanner.nextInt();
        }

        System.out.print("Enter the target point (format: x y): ");
        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();

        int nearestDrone = findNearestDrone(targetX, targetY, droneX, droneY);
        System.out.println("nearest drone = "+ nearestDrone);

        findTarget(targetX, targetY, droneX, droneY , nearestDrone, totalRows, totalColumns);

        scanner.close();
    }
}