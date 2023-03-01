package MultidimensionalArraysEx;

import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        String commands = scanner.nextLine();
        int startRowPlayer = -1;
        int startColPlayer = -1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("P")) {
                    startRowPlayer = row;
                    startColPlayer = col;
                }
            }
        }
        for (int i = 0; i < commands.length(); i++) {
            char direction = commands.charAt(i);
            matrix[startRowPlayer][startColPlayer] = ".";
            switch (direction) {
                case 'R':
                    startColPlayer++;
                    break;
                case 'L':
                    startColPlayer--;
                    break;
                case 'U':
                    startRowPlayer--;
                    break;
                case 'D':
                    startRowPlayer++;
                    break;

            }
            if(matrix[startRowPlayer][startColPlayer].equals("B")){
                System.out.println("dead: " + startRowPlayer + " " + startColPlayer);
                break;
            }
            matrix[startRowPlayer][startColPlayer] = "P";

        }


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
