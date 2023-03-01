package SetsAndMapsEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        Map<String, Integer> materialsMap = new TreeMap<>();
        Map<String, Integer> trashMap = new TreeMap<>();
        String regex = "(?<quantity>[0-9]+) (?<material>[a-z]+)";


        while (true) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                int quantity = Integer.parseInt(matcher.group("quantity"));
                String material = matcher.group("material");
                materialSearch(materialsMap, trashMap, quantity, material);
            }
            input = scanner.nextLine();
        }
    }

    private static void materialSearch(Map<String, Integer> materialsMap, Map<String, Integer> trashMap, int quantity, String material)
        {
            if (material.equals("fragments") || material.equals("shards")
                    || material.equals("motes")) {
                if (materialsMap.containsKey(material)) {
                    materialsMap.put(material, materialsMap.get(material) + quantity);
                } else {
                    materialsMap.put(material, quantity);
                }
            } else {
                if (trashMap.containsKey(material)) {
                    trashMap.put(material, trashMap.get(material) + quantity);
                } else {
                    trashMap.put(material, quantity);
                }
            }
            if (materialsMap.size() > 0) {
                if (materialsMap.get(material) >= 250) {
                    isEnoughQuantity(material);
                    int remainingMaterial = materialsMap.get(material) - 250;
                    materialsMap.put(material, remainingMaterial);

                }

            }

    }

    private static void isEnoughQuantity(String material) {
        if (material.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else if (material.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (material.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        }
    }
}
