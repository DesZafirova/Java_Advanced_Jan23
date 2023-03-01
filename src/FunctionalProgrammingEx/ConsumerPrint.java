package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
       Consumer<String> printNames = e -> System.out.println(e);
        Arrays.stream(names)
                .forEach(printNames);
    }
    //Consumer<String[]> printArray = array -> {
//    for (String name : array){
//        System.out.println(name);
    //}
}
