package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
        int num = Integer.parseInt(scanner.nextLine());
        Consumer<Integer> print = e -> System.out.print(e + " ");
        Collections.reverse(numbers);
        Predicate<Integer> isDivisible = e -> e % num != 0;
        numbers.stream()
                .filter(e -> isDivisible.test(e))
                .forEach(e -> print.accept(e));
    }
}
