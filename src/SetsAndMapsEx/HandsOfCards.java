package SetsAndMapsEx;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> personMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            String[] cards = (input.split(": ")[1]).split(", ");
            for (String card : cards) {
                if (personMap.containsKey(name)) {
                    personMap.get(name).add(card);
                } else {
                    personMap.put(name, new HashSet<>());
                    personMap.get(name).add(card);
                }
            }
            Set<String> cardSet = personMap.get(name);
            input = scanner.nextLine();
        }
        personMap.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });

        }



    private static int getCardsPoints(Set<String> cards) {
        //всяка един символ -> стойност
        Map<Character, Integer> symbolsValues = getSymbolsValues();
        int sumPoints = 0;
        //списък с карти: "2C", "4H", "9H", "AS", "QS"
        //всяка една карта -> намираме точките за картата -> доабвяме точките на картата към сумата от всички точки
        for (String card : cards) {
            //card = "2C" -> "[сила][тип]"
            //сила: 2 (2), 3(3), 4(4), 5(5), 6 (6), 7 (7), 8 (8), 9(9), 10(10), J(11), D(12), K(13), A(14)
            //тип: S(4), H(3), D(2), C(1)
            //точки = сила * тип

            int points = 0;
            if (card.startsWith("10")) {
                //картата е "10C"
                //сила = 10
                char type = card.charAt(2);
                points = 10 * symbolsValues.get(type);
            } else {
                //"4H"
                char power = card.charAt(0); //4
                char type = card.charAt(1); //H
                points = symbolsValues.get(power) * symbolsValues.get(type);
            }

            sumPoints += points;
        }
        //знаем сумата от точките за всички карти
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character, Integer> characterValues = new HashMap<>();
        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;

    }
}

