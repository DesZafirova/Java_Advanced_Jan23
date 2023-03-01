package MultidimentionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String[][] firstMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentSymbol = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                firstMatrix[i][j] = currentSymbol[j];
            }
        }
        String[][] secondMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] parts = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                if(firstMatrix[i][j].equals(parts[j])){
                    secondMatrix[i][j] = parts[j];
                }else{
                    secondMatrix[i][j] = "*";
                }
            }
        }
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[i].length; j++) {
                System.out.print(secondMatrix[i][j] + " ");
            }
            System.out.println();
        }


//        for (int i = 0; i < rows; i++) {
//            String[] parts = scanner.nextLine().split(" ");
//
//            for (int j = 0; j < cols; j++) {
//                secondMatrix[i][j] = parts[j];
//            }
//        }
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (firstMatrix[i][j].equals(secondMatrix[i][j])) {
//                    System.out.print(firstMatrix[i][j] + " ");
//                } else {
//                    System.out.print("* ");
//                }
//            }
//
//            System.out.println( " ");
//        }
//
//


    }

    public static void print2D(String mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }
    static void printIntersection(String A[][], String B[][]) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == B[i][j]) {
                    System.out.print(A[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }

            System.out.println( " ");
        }
    }
}
