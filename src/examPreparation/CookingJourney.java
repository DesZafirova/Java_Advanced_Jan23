package examPreparation;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][];
        fillMatrix(matrix, scanner);
        int firstPillarRow = -1;
        int firstPillarCol = -1;
        int secondPillarRow = -1;
        int secondPillarCol = -1;
        boolean weFindFirstPillar = false;
        int rowPlayer, colPlayer;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")) {
                    rowPlayer = row;
                    colPlayer = col;
                } else if (matrix[row][col].equals("P") && weFindFirstPillar == false) {
                    weFindFirstPillar = true;
                    firstPillarRow = row;
                    firstPillarCol = col;

                } else if (matrix[row][col].equals("P") && weFindFirstPillar) {
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }

            String moveCommand = scanner.nextLine();
            while(true) {
                
                switch (moveCommand) {
                    case "up":
                        break;
                    case "down":
                        break;
                    case "left":
                        break;
                    case "right":
                        break;

                }
            }
        }


    }private static void fillMatrix (String[][]matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("");
        }
    }
}

