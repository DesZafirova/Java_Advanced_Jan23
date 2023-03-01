package FunctionalProgrammingLab;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split(", "))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
        input.removeIf(e -> e % 2 != 0);
        printWithSeparator(input);
        System.out.println();

        List<Integer> sorted = input.stream().sorted().collect(Collectors.toList());
               //.forEach(e -> System.out.print(String.join(", ", (String.valueOf(e)))));
        printWithSeparator(sorted);
        System.out.println();

    }

    private static void printWithSeparator(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i));
            if(i < input.size()-1){
                System.out.print(", ");
            }
        }
    }
//    private static int increment(int num){
//        return num + 1;
//    }


//    private static boolean isOdd(int num) {
//        return num % 2 == 0;
//    }
}
