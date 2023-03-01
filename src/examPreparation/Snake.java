package examPreparation;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[size][];
        int snakeRow , snakeCol ;
        int lairFirstRow = -1, lairFirstCol = -1, lairSecondRow = -1, lairSecondCol = -1;
        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine();
            int snakeColumn = row.indexOf('S');
            if(snakeColumn > -1){
                snakeRow = i;
                snakeCol = snakeColumn;
            }
            int maybeLiarCol = row.indexOf('B');
             if(maybeLiarCol > -1){
                 if(lairFirstRow == -1){
                     lairFirstRow = i;
                     lairFirstCol = maybeLiarCol;
                 }else{
                     lairSecondRow = i;
                     lairSecondCol = maybeLiarCol;
                 }
             }

            matrix[i] = row.toCharArray();

        }
        int foodEaten = 0;
        boolean isSnakeWhithinLimits = true;
        while(isSnakeWhithinLimits && foodEaten < 10){
            String command = scanner.nextLine();


        }
    }

}
