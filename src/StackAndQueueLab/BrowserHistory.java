package StackAndQueueLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentUrl = "";
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (stack.size() > 1) {
                  stack.pop();
                  currentUrl = stack.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                stack.push(input);
                currentUrl = stack.peek();
                System.out.println(currentUrl);
            }

            input = scanner.nextLine();
        }
    }
}
