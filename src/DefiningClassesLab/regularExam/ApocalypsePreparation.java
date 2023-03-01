package regularExam;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ApocalypsePreparation {
    private static int PATCH_VALUE = 30;
    private static int BANDAGE_VALUE = 40;
    private static int MEDKIT_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> healingItems = new HashMap<>();
        healingItems.put("Patch", 0);
        healingItems.put("Bandage", 0);
        healingItems.put("MedKit", 0);

        int[] textilesArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        for (int textile : textilesArr) {
            textiles.offer(textile);
        }
        int[] medicamentArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> medicaments = new ArrayDeque<>();
        for (int medicament : medicamentArr) {
            medicaments.push(medicament);
        }
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int currentTextile = textiles.poll();
            int currentMedicament = medicaments.pop();
            int sum = currentTextile + currentMedicament;

            if (sum == PATCH_VALUE) {
                healingItems.put("Patch", healingItems.get("Patch") + 1);

            } else if (sum == BANDAGE_VALUE) {
                healingItems.put("Bandage", healingItems.get("Bandage") + 1);

            } else if (sum == MEDKIT_VALUE) {
                healingItems.put("MedKit", healingItems.get("MedKit") + 1);
            } else if (sum > MEDKIT_VALUE) {
                healingItems.put("MedKit", healingItems.get("MedKit") + 1);
                sum -= MEDKIT_VALUE;
                int newValue = medicaments.pop() + sum;
                medicaments.push(newValue);

            } else {

                int medicalValue = currentMedicament + 10;
                medicaments.push(medicalValue);
            }


        }
        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }
        healingItems = healingItems.entrySet().stream().sorted((s1, s2) -> s2.getValue() - s1.getValue()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        for (String item : healingItems.keySet()) {
            if (healingItems.get(item) > 0) {
                System.out.printf("%s - %d\n", item, healingItems.get(item));
            }
        }
        if (!textiles.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.println(textiles.toString().replaceAll("[\\[\\]]", ""));
        } else if (!medicaments.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.println(medicaments.toString().replaceAll("[\\[\\]]", ""));
        }


    }
}
