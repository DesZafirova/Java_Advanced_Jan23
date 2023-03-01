package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted()
                .collect(Collectors.toList());

        Predicate<Integer> getOdd = e -> e % 2 == 0;
        Predicate<Integer> getEven = e -> e % 2 != 0;
        numbersList.stream().filter(getOdd)
                .forEach(e -> System.out.print(e + " "));
   numbersList.stream().filter(getEven).forEach(e -> System.out.print(e + " "));
    }
}
