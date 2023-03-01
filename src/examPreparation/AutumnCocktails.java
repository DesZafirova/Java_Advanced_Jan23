package examPreparation;

import java.util.*;

public class AutumnCocktails {
    private static final int PEAR_SOUR = 150;
    private static final int THE_HARVEST = 250;
    private static final int APPLE_HINNY = 300;
    private static final int HIGH_FASHION = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (String ingredient : tokens) {
            ingredients.offer(Integer.parseInt(ingredient));
        }
        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        for (String fresh : tokens) {
            freshness.push(Integer.parseInt(fresh));
        }
        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            Integer firstIngredient = ingredients.poll();
            if(firstIngredient == 0){
                continue;
            }
            Integer lastFreshness = freshness.pop();
            int totalLevel = firstIngredient * lastFreshness;

            switch (totalLevel) {
                case PEAR_SOUR:
                    int currentPearCocktail = cocktails.get("Pear Sour");
                    cocktails.put("Pear Sour", ++currentPearCocktail);
                    break;
                case THE_HARVEST:
                    int currentTheHarvest = cocktails.get("The Harvest");
                    currentTheHarvest++;
                    cocktails.put("The Harvest", currentTheHarvest);
                    break;
                case APPLE_HINNY:
                    int currentAppleHinny = cocktails.get("Apple Hinny");
                    cocktails.put("Apple Hinny", ++currentAppleHinny);
                    break;
                case HIGH_FASHION:
                    int currentHighFashion = cocktails.get("High Fashion");
                    cocktails.put("High Fashion", ++currentHighFashion);
                    break;
                default:
                    firstIngredient += 5;
                    ingredients.offer(firstIngredient);
                    break;

            }
        }
        if (cocktails.get("Pear Sour") > 0 && cocktails.get("Apple Hinny") > 0
                && cocktails.get("The Harvest") > 0 && cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if(!ingredients.isEmpty()){

            int leftOverIngredients = ingredients.stream().mapToInt(e -> e).sum();
            System.out.println("Ingredients left: " + leftOverIngredients);
        }
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if(entry.getValue() > 0){
            System.out.printf("# %s --> %d\n", entry.getKey(), entry.getValue());
        }}


//        if (cocktails.get("Apple Hinny") > 0) {
//            System.out.printf("# Apple Hinny --> %d\n", cocktails.get("Apple Hinny"));
//        }
//        if (cocktails.get("High Fashion") > 0) {
//            System.out.printf("# High Fashion --> %d\n", cocktails.get("High Fashion"));
//        }
//        if (cocktails.get("Pear Sour") > 0) {
//            System.out.printf("# Pear Sour --> %d\n", cocktails.get("Pear Sour"));
//        }
//        if (cocktails.get("The Harvest") > 0) {
//            System.out.printf("# The Harvest --> %d\n", cocktails.get("The Harvest"));
//        }


    }
}
