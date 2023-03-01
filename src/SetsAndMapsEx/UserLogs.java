package SetsAndMapsEx;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].split("=")[1];
            String username = input.split("\\s+")[2].split("=")[1];

            if (!map.containsKey(username)) {
                map.put(username, new LinkedHashMap<>());
            }
            //дай ми стойността ot map-a срещу username-a/ value-то
            // -> взимаме IP-тата срещу user-а
            Map<String, Integer> logs = map.get(username);

            if (!logs.containsKey(ip)) {
                logs.put(ip, 1);
            } else {
                logs.put(ip, logs.get(ip) + 1);
            }

            input = scanner.nextLine();
        }
        for (String username : map.keySet()) {
            //списък с username-И
            System.out.println(username + ": ");
            //вс IP-та на username-а
            Map<String, Integer> currentIps = map.get(username);
            int countIP = currentIps.size();
            for (String ip : currentIps.keySet()) {
                if (countIP == 1) {
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    System.out.println(ip + " => " + currentIps.get(ip) + ", ");
                }
                countIP--;
            }
        }


    }
}
