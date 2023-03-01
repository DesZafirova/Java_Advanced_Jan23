package SetsAndMapsLab;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<Integer> set = new TreeSet<>();
        Collections.sort(numbersList);
        Collections.reverse(numbersList);
        if (numbersList.size() < 3) {
            for (int e : numbersList
            ) {
                System.out.print(e + " ");
            }
        } else {
            int count = 0;
            for (int i = 0; i < numbersList.size(); i++) {
                System.out.print(numbersList.get(i) + " ");
                count++;
                if ((count == 3)) {
                    break;
                }
            }
        }



    }
}
