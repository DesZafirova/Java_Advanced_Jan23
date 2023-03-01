package examPreparation;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);
        int rowPlayer = -1;
        int colPlayer = -1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("f")) {
                    rowPlayer = row;
                    colPlayer = col;
                }
            }
        }
        boolean hasWon = false;
        for (int countCommand = 0; countCommand < countCommands; countCommand++) {
            String direction = scanner.nextLine();

            int newRow = 0;
            int newCol = 0;
            switch (direction) {
                case "up":
                    newRow = checkIsOutside(rowPlayer - 1, size);
                    newCol = colPlayer;
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIsOutside(rowPlayer - 2, size);
                        newCol = colPlayer;
                    }
                    break;
                case "down":
                    newRow = checkIsOutside(rowPlayer + 1,size);
                    newCol = colPlayer;
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIsOutside(rowPlayer + 2, size);
                        newCol = colPlayer;
                    }
                    break;
                case "left":
                    newRow = rowPlayer;
                    newCol = checkIsOutside(colPlayer - 1,size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = rowPlayer;
                        newCol = checkIsOutside(colPlayer - 2,size);
                    }
                    break;
                case "right":
                    newRow = rowPlayer;
                    newCol = checkIsOutside(colPlayer + 1, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = rowPlayer;
                        newCol = checkIsOutside(colPlayer + 2, size);
                    }
                    break;
            }
            if (matrix[newRow][newCol].equals("T")) {
                newRow = rowPlayer;
                newCol = colPlayer;
            } else {
                if (matrix[newRow][newCol].equals("F")) {
                    hasWon = true;
                    matrix[rowPlayer][colPlayer] = "-";
                    matrix[newRow][newCol] = "f";
                    break;
                }
                matrix[rowPlayer][colPlayer] = "-";
                matrix[newRow][newCol] = "f";
                rowPlayer = newRow;
                colPlayer = newCol;
            }
        }
        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);


    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int checkIsOutside(int value, int size) {
        if (value < 0) {
            value = size - 1;
        } else if (value >= size) {
            value = 0;
        }
        return value;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");

        }

    }

}



