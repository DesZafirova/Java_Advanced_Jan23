package StackAndQueueLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> pages = new ArrayDeque<>();
        ArrayDeque<String> nextPages = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (pages.size() > 1) {
                    nextPages.push(pages.pop());
                    System.out.println(pages.peek());

                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (nextPages.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    pages.push(nextPages.pop());
                    System.out.println(pages.peek());
                }


            } else {
                nextPages.clear();
                pages.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();

        }
    }
}
