package SetsAndMapsEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> map = new LinkedHashMap<>();
        while (!name.equals("stop")) {
//            String email = scanner.nextLine();
//            if(!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")){
//                map.put(name, email);
//            }
//           name = scanner.nextLine();
//        }
//
//
//        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
//    }

            while (!name.equals("stop")) {
                String email = scanner.nextLine();
                map.put(name, email);
                name = scanner.nextLine();
            }
            map.entrySet().removeIf(entry ->
                    entry.getValue().endsWith("uk")
                            || entry.getValue().endsWith("us")
                            || entry.getValue().endsWith("com"));

            map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
        }

    }
}
