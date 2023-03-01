package SetsAndMapsEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phoneMap.put(name, number);
            input = scanner.nextLine();
        }
        String search = scanner.nextLine();
        while(!search.equals("stop")){
            if(phoneMap.containsKey(search)){
                System.out.println(search + " -> " + phoneMap.get(search));
            }else {
                System.out.printf("Contact %s does not exist.%n", search);
            }
            search = scanner.nextLine();
        }
    }
}
