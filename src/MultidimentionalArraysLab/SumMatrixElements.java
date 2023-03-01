package MultidimentionalArraysLab;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(parts[0]);
        int cols = Integer.parseInt(parts[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getSumOfMatrix(matrix));
    }
    public static int getSumOfMatrix (int mat [][]){
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <mat[i].length ; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
}
