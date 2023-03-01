package MultidimensionalArraysEx;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class ReverseMatrixDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, rows, cols, scanner);
        int row = rows - 1;
        int col = cols - 1;

        while (row != -1) {
            int r = row;
            int c = col;
            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

    private static void fillMatrix(int[][] matrix, int rows, int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

    }
    private static boolean isInbounds(int row, int col, int [][] matrix) {
        return row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1;
    }
}
