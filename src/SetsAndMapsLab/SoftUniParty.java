package SetsAndMapsLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> gusts = new TreeSet<>();
        while (!input.equals("PARTY")) {
            gusts.add(input);

            input = scanner.nextLine();

        }
        input = scanner.nextLine();
        while (!input.equals("END")) {
            gusts.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(gusts.size());
        for (String guest : gusts) {
            System.out.println(guest);
        }

    }
}
