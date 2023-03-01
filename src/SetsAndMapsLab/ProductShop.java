package SetsAndMapsLab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> map = new TreeMap<>();
        Map<String, Double> priceMap = new HashMap<>();

        while (!input.equals("Revision")) {
            String[] inputLine = input.split(", ");
            String shopName = inputLine[0];
            String productName = inputLine[1];
            double price = Double.parseDouble(inputLine[2]);
            if (map.containsKey(shopName)) {
                map.get(shopName).add(productName);
                priceMap.put(productName, price);
            } else {
                map.put(shopName, new ArrayList<>());
                map.get(shopName).add(productName);
                priceMap.put(productName, price);

            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (String product: entry.getValue()){
                System.out.printf("Product: %s, Price: %.1f%n", product, priceMap.get(product));
            }

        }


    }

}
