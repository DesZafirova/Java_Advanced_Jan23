package ListUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
List<Integer> list = new ArrayList<>();
list.add(5);
list.add(3);
list.add(51);
list.add(500);
list.add(0);
        System.out.println(ListUtils.getMax(list));
        System.out.println(ListUtils.getMin(list));

    }
}
