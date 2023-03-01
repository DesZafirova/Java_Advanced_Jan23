package examPreparation;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerEnergy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        String[][] chamber = new String[rows][];
        fillMatrix(chamber, scanner);
        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < chamber[row].length; col++) {
                if (chamber[row][col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String inputLine = scanner.nextLine();
        while (true) {
            String[] prats = inputLine.split("\\s+");
            String command = prats[0];
            int row = Integer.parseInt(prats[1]);
            int col = Integer.parseInt(prats[2]);
            chamber[row][col] = "S";
            chamber[playerRow][playerCol] = "-";
            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        playerRow--;
                    }
                    break;
                case "down":
                    if (playerRow + 1 < chamber.length) {
                        playerRow++;
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        playerCol--;
                    }
                    break;
                case "right":
                    if (playerCol + 1 < chamber.length) {
                        playerRow++;
                    }
                    break;
            }
            playerEnergy--;
            if (playerEnergy <= 0) {
                dead(playerEnergy, chamber, playerRow, playerCol);
                break;
            }
            if (chamber[playerRow][playerCol].equals("S")) {
                playerEnergy -= 2;
                if (playerEnergy <= 0) {
                    dead(playerEnergy, chamber, playerRow, playerCol);
                    break;
                } else {
                    chamber[playerRow][playerCol] = "P";
                }
            } else if (chamber[playerRow][playerCol].equals("H")) {
                chamber[playerRow][playerCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", playerEnergy);
                printMatrix(chamber);
                break;
            } else if (chamber[playerRow][playerCol].equals("-")) {
                chamber[playerRow][playerCol] = "P";
            }
            inputLine = scanner.nextLine();
        }

    }

    private static void dead(int energy, String[][] matrix, int row, int col) {
        matrix[row][col] = "X";
        System.out.printf("Paris died at %d;%d.%n", row, col);
        printMatrix(matrix);
    }


    private static void fillMatrix(String[][] chamber, Scanner scanner) {
        for (int row = 0; row < chamber.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            chamber[row] = scanner.nextLine().split("");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}





