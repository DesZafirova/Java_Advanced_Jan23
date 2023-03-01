package StackAndQueueLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
       if (decimal==0){
           System.out.println(0);
       }else {
           while (decimal != 0) {
               int leftOver = decimal % 2;
               stack.push(leftOver);
               decimal = decimal / 2;
           }

           for (Integer integer : stack) {
               System.out.print(integer);
               //Обхожда стека
           }
       }
    }
}
