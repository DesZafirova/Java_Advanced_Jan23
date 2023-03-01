package examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> maleList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> male = new ArrayDeque<>();
        for (int m : maleList) {
            male.push(m);
        }

        List<Integer> femaleList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> female = new ArrayDeque<>();

        for (int f : femaleList) {
            female.offer(f);
        }
        int match = 0;
        while (female.size() > 0 && male.size() > 0) {
            int currentMale = male.peek();
            int currentFemale = female.peek();
            if (currentMale <= 0 || currentFemale <= 0) {
                if (currentMale <= 0) {
                    male.pop();
                } else {
                    female.poll();
                }
               continue;
            }
            if (currentMale % 25 == 0) {
                male.pop();
                male.pop();
                continue;
            } else if (currentFemale % 25 == 0) {
                female.poll();
                female.poll();
                continue;
            }
            if (currentMale == currentFemale) {
                match++;
                male.pop();
                female.poll();
            } else {
                female.poll();
                int decrease = male.pop() - 2;
                male.push(decrease);
            }


        }
        System.out.println("Matches: " + match);
        System.out.print("Males left: ");
        if(male.size()>0) {
            printWithSeparatorStack(male);
        }else {
            System.out.println("none");

        }
        System.out.print("Females left: ");
        if(female.size()>0){
            printWithSeparatorQueue(female);
        }else {
            System.out.println("none");
        }
    }
    private static void printWithSeparatorQueue(ArrayDeque<Integer> queue) {
        while (queue.size() > 0) {
            if(queue.size() > 1) {
                System.out.print(queue.poll() + ", ");
            }
            else if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
        }
    }  private static void printWithSeparatorStack(ArrayDeque<Integer> stack) {
        while (stack.size() > 0) {
            if(stack.size()>1){

                System.out.print(stack.pop() + ", ");
            }
            else if (stack.size() == 1) {
                System.out.println(stack.pop());
                break;
            }
        }
    }
}
