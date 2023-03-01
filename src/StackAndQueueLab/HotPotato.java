package StackAndQueueLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < names.length; i++) {
            queue.offer(names[i]);

        }
       while (queue.size() != 1){
           for (int i = 1; i < n ; i++) {
               String currentChild = queue.poll();
               queue.offer(currentChild);
           }
           String childToRemove = queue.poll();
           System.out.println("Removed " + childToRemove);
       }
       String lastChild = queue.peek();
        System.out.println("Last is " + lastChild);

    }
}
