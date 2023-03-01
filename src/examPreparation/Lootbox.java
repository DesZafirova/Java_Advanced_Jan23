package examPreparation;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstBox = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondBox = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> first = new ArrayDeque<>();
        for (int i = 0; i < firstBox.length; i++) {
            first.offer(firstBox[i]);
        }
        ArrayDeque<Integer> second = new ArrayDeque<>();
        for (int i = 0; i < secondBox.length; i++) {
            second.push(secondBox[i]);
        }
        List<Integer> loot = new ArrayList<>();
         while (first.size() > 0 && second.size() > 0) {
            int currentSum = first.peek() + second.peek();
            if (isEven(currentSum)) {
                loot.add(first.peek());
                loot.add(second.peek());
                first.poll();
                second.pop();
            } else {
                int element = second.peek();
                second.pop();
                first.offer(element);
            }

            if (first.size() == 0) {
                System.out.println("First lootbox is empty");
                break;
            } else if (second.size() == 0) {
                System.out.println("Second lootbox is empty");
                break;
            }
        }
        int sum = 0;
        for (int e : loot) {
            sum += e;
        }
        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sum);
        }

    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
