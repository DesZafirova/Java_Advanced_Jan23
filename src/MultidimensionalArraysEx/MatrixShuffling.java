package MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (validateCommand(command, rows, cols)) {
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);


                String firstElem = matrix[row1][col1];
                String secondElem = matrix[row2][col2];

                matrix[row1][col1] = secondElem;
                matrix[row2][col2] = firstElem;

                printMatrix(matrix, rows, cols);
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }


    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        String[] commandParts = command.split("\\s+");
        if (commandParts.length != 5) {
            return false;
        }
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }
}
