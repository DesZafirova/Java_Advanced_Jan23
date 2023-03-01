package StackAndQueueLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());
            int result = 0;
            if (operator.equals("+")) {
                result = firstNum + secondNum;
            } else {
                result = firstNum - secondNum;
            }
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.peek());

    }
}
