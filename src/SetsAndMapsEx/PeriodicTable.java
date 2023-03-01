package SetsAndMapsEx;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalCompounds = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (String el : input){
                chemicalCompounds.add(el);
            }
        }
        chemicalCompounds.stream().forEach(el -> System.out.print(el + " "));
    }
}
