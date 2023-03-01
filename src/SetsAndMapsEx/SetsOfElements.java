package SetsAndMapsEx;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int first = Integer.parseInt(input.split("\\s+")[0]);
        int second = Integer.parseInt(input.split("\\s+")[1]);
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        for (int i = 0; i < first; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNumber);
        }
        for (int i = 0; i < second; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentNumber);
        }
        // без функционалност :
//        Set<Integer> duplicate = new LinkedHashSet<>();
//        for (int number : firstSet) {
//            if(secondSet.contains(number)){
//                duplicate.add(number);
//            }
//        }
//        duplicate.forEach(System.out::println);

        firstSet.retainAll(secondSet);//премахва всички елементи от първия сет, които ги няма във втория
// остават само елементите, които ги има във втория ред
        //тогава искам всеки елемент на първия и да ги отпечаташ
        firstSet.forEach(element -> System.out.print( element + " "));
    }
}
