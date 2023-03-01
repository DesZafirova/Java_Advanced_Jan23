package SetsAndMapsEx;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> symbolsMap = new TreeMap<>();
        for (char symbol : text.toCharArray()) {
            if (symbolsMap.containsKey(symbol)) {
                symbolsMap.put(symbol, symbolsMap.get(symbol) + 1);
            } else {
                symbolsMap.put(symbol, 1);
            }
        }
        symbolsMap.entrySet().stream().forEach(e ->
                System.out.printf("%c: %d time/s%n", e.getKey(), e.getValue()));
    }
}