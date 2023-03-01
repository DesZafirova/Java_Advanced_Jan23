package examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> liquidsList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> ingredientsList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> milligramsCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        for (int i = 0; i < liquidsList.size(); i++) {
            milligramsCaffeine.push(liquidsList.get(i));
        }
        for (int i = 0; i < ingredientsList.size(); i++) {
            energyDrinks.offer(ingredientsList.get(i));
        }
        int maxCaffeine = 300;
        int drunkCaffeine = 0;
        while (drunkCaffeine <= 300) {
            int currentCaffeine = milligramsCaffeine.peek() * energyDrinks.peek();
            if (currentCaffeine + drunkCaffeine <= maxCaffeine) {
                drunkCaffeine+=currentCaffeine;
                milligramsCaffeine.pop();
                energyDrinks.poll();
            } else {
                milligramsCaffeine.pop();
                int currentDrink = energyDrinks.poll();
                energyDrinks.offer(currentDrink);
                drunkCaffeine -= 30;
                if(drunkCaffeine<0){
                    drunkCaffeine = 0;
                }
            }

            if (milligramsCaffeine.size() == 0 || energyDrinks.size() == 0) {
                break;
            }
        }
        if (!energyDrinks.isEmpty()) {
            System.out.print("Drinks left: ");
            printWithSeparatorQueue(energyDrinks);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", drunkCaffeine);

    }

    private static void printWithSeparatorQueue(ArrayDeque<Integer> queue) {
        while (queue.size() > 1) {
            System.out.print(queue.poll() + ", ");
            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
        }
    }
}
