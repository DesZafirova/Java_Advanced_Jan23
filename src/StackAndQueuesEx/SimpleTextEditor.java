package StackAndQueuesEx;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //брой команди
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int commandNumber = 1; commandNumber <= n; commandNumber++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                stack.push(currentText.toString());
                String textToAppend = command.split("\\s+")[1];
                currentText.append(textToAppend);
            } else if (command.startsWith("2")) {
                stack.push(currentText.toString());
                int countOfElements = Integer.parseInt(command.split("\\s+")[1]);
                int startIndexForDelete = currentText.length() - countOfElements;
                currentText.delete(startIndexForDelete, currentText.length());

            } else if (command.startsWith("3")) {
                int index = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(currentText.charAt(index - 1));//мястото на буквата в текста е индекса-1
            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    String last = stack.pop();
                    currentText = new StringBuilder(last);
                }
            }
        }
    }
}
