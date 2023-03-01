package SetsAndMapsLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, List<String>>> continentMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String continent = inputLine[0];
            String country = inputLine[1];
            String city = inputLine[2];

            if (!continentMap.containsKey(continent)) {
                continentMap.put(continent, new LinkedHashMap<>());

            }
            Map<String, List<String>> countryMap = continentMap.get(continent);
            if (countryMap.containsKey(country)) {
                countryMap.get(country).add(city);
            } else {
                countryMap.put(country, new ArrayList<>());
                countryMap.get(country).add(city);
            }

        }
        for(String cont : continentMap.keySet()){
            System.out.println(cont + ":");
            Map<String, List<String>> countries = continentMap.get(cont);
            for (String c : countries.keySet()) {
                System.out.print(c + " -> ");
               List<String> cities = countries.get(c);
                System.out.print(String.join( ", ", cities));
                System.out.println();
            }
        }
    }
}
