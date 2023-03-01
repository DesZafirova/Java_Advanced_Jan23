package SetsAndMapsEx;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> usersWithTime = new TreeMap<>();
        TreeMap<String, TreeSet<String>> addresses = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String ip = inputLine[0];
            String user = inputLine[1];
            int duration = Integer.parseInt(inputLine[2]);
            if(!usersWithTime.containsKey(user)){
                usersWithTime.put(user, duration);
                addresses.put(user, new TreeSet<>(){{add(ip);}});
            }else {
                usersWithTime.put(user, usersWithTime.get(user) + duration);
                addresses.get(user).add(ip);
            }
        }
        usersWithTime.forEach((key, value) ->{
            System.out.println(String.format("%s: %d %s", key, value, addresses.get(key).toString()));
        });


    }
}
