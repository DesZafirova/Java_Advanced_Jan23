package examPreparation;

import java.util.*;

public class OSTasks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasksArr = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] threatsArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

       Stack<Integer> tasks = new Stack<>();
        for (int i = 0; i < tasksArr.length; i++) {
            tasks.push(tasksArr[i]);
        }
        Queue<Integer> threats = new ArrayDeque<>();
        for (int i = 0; i < threatsArr.length; i++) {
            threats.offer(threatsArr[i]);
        }
        int valueToKill = Integer.parseInt(scanner.nextLine());
        boolean isKilled = false;
        while (true) {
            if (tasks.peek() == valueToKill) {
                isKilled = true;
                break;
            }
            if (threats.size() > 0 && tasks.size() > 0) {
                int currentThreat = threats.peek();
                int currentTask = tasks.peek();
                if (currentThreat >= currentTask) {
                    threats.poll();
                    tasks.pop();
                } else {

                        threats.poll();
                    }

                }

            }
        if (isKilled) {
            System.out.printf("Thread with value %d killed task %d%n", threats.peek(), valueToKill);
            for (int value : threats) {
                System.out.print(value + " ");
            }
        }
        }

    }

