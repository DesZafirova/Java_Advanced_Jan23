package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        Function<List<Integer>, List<Integer>> addNumbers = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyNumbers = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractNumbers = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());


        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addNumbers.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyNumbers.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractNumbers.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;

            }
            command = scanner.nextLine();
        }
    }
}
