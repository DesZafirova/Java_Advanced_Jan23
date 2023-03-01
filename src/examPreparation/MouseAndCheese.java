package examPreparation;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);
        int rowMouse = -1;
        int colMouse = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("M")) {
                    rowMouse = row;
                    colMouse = col;
                }
            }
        }
        int cheese = 0;
        boolean isOutOfRange = false;
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            matrix[rowMouse][colMouse] = "-";
            switch (command) {
                case "up":
                    rowMouse--;
                    break;
                case "down":
                    rowMouse++;

                    break;
                case "left":
                    colMouse--;

                    break;
                case "right":
                    colMouse++;

                    break;
            }
            if (colMouse < 0 || colMouse >= n || rowMouse < 0 || rowMouse >= n){
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[rowMouse][colMouse].equals("c")){
                cheese++;
            } else if (matrix[rowMouse][colMouse].equals("B")) {
                continue;
            }
            matrix[rowMouse][colMouse]= "M";

            command = scanner.nextLine();
        }
        if(cheese < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
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
    }


    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
