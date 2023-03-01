package SetsAndMapsLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> numbers = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" ");
        for (String number : input) {
            double current = Double.parseDouble(number);
            if (numbers.containsKey(current)) {
                int count = numbers.get(current);
                numbers.put(current, count + 1);
            } else {
                numbers.put(current, 1);
            }
        }
        for (Double currentNumber : numbers.keySet()) {
            System.out.printf("%.1f -> %d%n", currentNumber, numbers.get(currentNumber));
        }
    }
}
