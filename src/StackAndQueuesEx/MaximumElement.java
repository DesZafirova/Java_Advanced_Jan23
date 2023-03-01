package StackAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String inputLine = scanner.nextLine();
            if(inputLine.startsWith("1")){
                int number = Integer.parseInt(inputLine.split("\\s+")[1]);
                stack.push(number);
            } else if (inputLine.equals("2")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }

            } else if (inputLine.equals("3")) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
