package examPreparation;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        int rowPlayer = -1, colPlayer = -1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("B")) {
                    rowPlayer = row;
                    colPlayer = col;
                }
            }
        }
        String command = scanner.nextLine();
        int countMove = 0;
        int countTouchedOpponents = 0;
        while (!command.equals("Finish")) {
            matrix[rowPlayer][colPlayer] = "-";
            int newRow = rowPlayer;
            int newCol = colPlayer;

            switch (command) {
                case "up":
                    if (!isInside(rowPlayer - 1, colPlayer, matrix)) {
                        matrix[rowPlayer][colPlayer] = "B";
                        command = scanner.nextLine();
                        continue;
                    } else {
                        rowPlayer--;
                    }
                    break;
                case "down":
                    if (!isInside(rowPlayer + 1, colPlayer, matrix)) {
                        matrix[rowPlayer][colPlayer] = "B";
                        command = scanner.nextLine();
                        continue;
                    } else {
                        rowPlayer++;
                    }
                    break;
                case "left":
                    if (!isInside(rowPlayer, colPlayer - 1, matrix)) {
                        matrix[rowPlayer][colPlayer] = "B";
                        command = scanner.nextLine();
                        continue;

                    } else {
                        colPlayer--;

                    }
                    break;
                case "right":
                    if (!isInside(rowPlayer, colPlayer + 1, matrix)) {
                        matrix[rowPlayer][colPlayer] = "B";
                        command = scanner.nextLine();
                        continue;

                    } else {
                        colPlayer++;
                    }
                    break;

            }
            if (matrix[rowPlayer][colPlayer].equals("O")) {
                rowPlayer = newRow;
                colPlayer = newCol;
            } else if (matrix[rowPlayer][colPlayer].equals("P")) {
                countTouchedOpponents++;
                countMove++;
            } else if (matrix[rowPlayer][colPlayer].equals("-")) {
                countMove++;
            }
            matrix[rowPlayer][colPlayer] = "B";
            if (countTouchedOpponents == 3) {
                break;
            }


            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", countTouchedOpponents, countMove);


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }

    private static boolean isInside(int row, int col, String[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        } else return true;
    }

}
