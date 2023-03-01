package MultidimensionalArraysEx;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);
        int submarineRow = -1;
        int submarineCol = -1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                }
            }
        }
        String command = scanner.nextLine();
        int bomb = 0;
        int cruiserCount = 0;
        while (true) {
            matrix[submarineRow][submarineCol] = "-";
            if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineCol--;
            } else if (command.equals("right")) {
                submarineCol++;
            }
            String submarinePosition =  matrix[submarineRow][submarineCol];
            if(submarinePosition.equals("-")) {
                matrix[submarineRow][submarineCol] = "S";
            } else if (submarinePosition.equals("*")) {
                matrix[submarineRow][submarineCol] = "S";
                bomb++;
                if(bomb == 3){
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    break;
                }
            } else if (submarinePosition.equals("C")) {
                cruiserCount++;
                matrix[submarineRow][submarineCol] = "S";
                if(cruiserCount==3){
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }


            command = scanner.nextLine();
        }
        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}