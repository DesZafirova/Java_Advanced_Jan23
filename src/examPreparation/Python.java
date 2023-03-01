package examPreparation;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commandsArr = scanner.nextLine().split(", ");
        String[][] screen = new String[size][size];
        fillMatrix(screen, scanner);
        int snakeRow = -1, snakeCol = -1;
        int length = 1;
        int foodToBeEaten = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (screen[row][col].equals("s")) {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (screen[row][col].equals("f")) {
                    foodToBeEaten++;
                }
            }
        }
        boolean allFoodIsEaten = false;

        for (int i = 0; i < commandsArr.length; i++) {
            String command = commandsArr[i];
            screen[snakeRow][snakeCol] = "*";
            switch (command) {
                case "up":
                    if (snakeRow - 1 < 0) {
                        snakeRow = size - 1;
                    }else {
                        snakeRow--;
                    }
                    break;
                case "down":
                    if (snakeRow + 1 > size - 1) {
                        snakeRow = 0;
                    }else {
                        snakeRow++;
                    }

                    break;
                case "left":
                    if (snakeCol - 1 < 0) {
                        snakeCol = size - 1;
                    }else {
                        snakeCol--;
                    }
                    break;
                case "right":
                    if (snakeCol + 1 > size - 1) {
                        snakeCol = 0;
                    }else {
                        snakeCol++;
                    }
                    break;
            }
            if (screen[snakeRow][snakeCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (screen[snakeRow][snakeCol].equals("f")) {
                length++;
                foodToBeEaten--;
            }
            screen[snakeRow][snakeCol] = "s";
            if (foodToBeEaten == 0) {
                allFoodIsEaten = true;
                break;

            }
        }
        if(allFoodIsEaten){
            System.out.printf("You win! Final python length is %d\n", length);

        }else{
            System.out.printf("You lose! There is still %d food to be eaten.\n", foodToBeEaten);

        }



        }
     private static void fillMatrix (String[][]matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}