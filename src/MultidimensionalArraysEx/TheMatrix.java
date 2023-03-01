package MultidimensionalArraysEx;

import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        String fillSymbol = scanner.nextLine();
        String[] startParts = scanner.nextLine().split(" ");
        int startRow = Integer.parseInt(startParts[0]);
        int startCol = Integer.parseInt(startParts[1]);
        String startSymbol = matrix[startRow][startCol];
        matrix[startRow][startCol] = fillSymbol;



    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
