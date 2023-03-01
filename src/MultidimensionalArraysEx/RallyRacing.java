package MultidimensionalArraysEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        int km = 0;//изминати километри
        String[][] trace = new String[n][n];
        fillMatrix(trace, scanner);
        //ред и колона където се намира колата
        int currentRow = 0;
        int currentCol = 0;
        // намираме тунелите -> T
        List<Integer> tunnelList = new ArrayList<>();
        findTunnels(trace, tunnelList);

        String direction = scanner.nextLine();


        while (!direction.equals("End")) {

            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            String movedPlace = trace[currentRow][currentCol];
            if (".".equals(movedPlace)) {
                km += 10;
            } else if ("F".equals(movedPlace)) {
                km += 10;
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                break;
            } else if ("T".equals(movedPlace)) {

                currentRow = tunnelList.get(2);
                currentCol = tunnelList.get(3);
                km += 30;
                trace[tunnelList.get(0)][tunnelList.get(1)] = ".";
                trace[tunnelList.get(2)][tunnelList.get(3)] = ".";


            }
            direction = scanner.nextLine();
        }
        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", km);

        trace[currentRow][currentCol] = "C";

        printMatrix(trace);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelArr) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace.length; col++) {
                if (trace[row][col].equals("T")) {
                    tunnelArr.add(row);
                    tunnelArr.add(col);
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
