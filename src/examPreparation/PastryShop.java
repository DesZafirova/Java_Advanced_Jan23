package examPreparation;

import java.util.*;

import java.util.stream.Collectors;

public class PastryShop {
    private static final int BISCUIT_VALUE = 25;
    private static final int CAKE_VALUE = 50;
    private static final int PASTRY_VALUE = 75;
    private static final int PIE_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> liquidsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> ingredientsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> liquid = new ArrayDeque<>();
        ArrayDeque<Integer> ingredient = new ArrayDeque<>();
        for (int i = 0; i < liquidsList.size(); i++) {
            liquid.offer(liquidsList.get(i));
        }
        for (int i = 0; i < ingredientsList.size(); i++) {
            ingredient.push(ingredientsList.get(i));
        }

        int biscuitCount = 0;    //25
        int cakeCount = 0;     //	50
        int pastryCount = 0;   //	75
        int pieCount = 0;    //	100

        while (liquid.size()>0 && ingredient.size()>0) {

            if (liquid.peek() + ingredient.peek() == BISCUIT_VALUE) {
                liquid.poll();
                ingredient.pop();
                biscuitCount++;
            } else if (liquid.peek() + ingredient.peek() == CAKE_VALUE) {
                liquid.poll();
                ingredient.pop();
                cakeCount++;
            } else if (liquid.peek() + ingredient.peek() == PASTRY_VALUE) {
                liquid.poll();
                ingredient.pop();
                pastryCount++;
            } else if (liquid.peek() + ingredient.peek() == PIE_VALUE) {
                liquid.poll();
                ingredient.pop();
                pieCount++;
            } else {
                liquid.poll();
                int quantity = ingredient.peek();
                ingredient.pop();
                quantity += 3;
                ingredient.push(quantity);
            }
//            if (liquid.isEmpty() || ingredient.isEmpty()) {
//                break;
//            }
        }


        if (biscuitCount > 0 && cakeCount > 0 && pastryCount > 0 && pieCount > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquid.isEmpty() || ingredient.isEmpty()) {
            System.out.println("Liquids left: none");

        } else {
            System.out.print("Liquids left: ");
           // printWithSeparatorQueue(liquid);
            System.out.println(liquid.toString().replaceAll("[\\[\\]]", ""));

        }
        if (ingredient.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
           // printWithSeparatorStack(ingredient);
            System.out.println(ingredient.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.println("Biscuit: " + biscuitCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Pie: " + pieCount);
        System.out.println("Pastry: " + pastryCount);


    }

   /* private static void printWithSeparatorQueue(ArrayDeque<Integer> queue) {
        while (queue.size() > 1) {
            System.out.print(queue.poll() + ", ");
            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
        }
    }*/

  /*  private static void printWithSeparatorStack(ArrayDeque<Integer> stack) {
        while (stack.size() > 1) {
            System.out.print(stack.pop() + ", ");
            if (stack.size() == 1) {
                System.out.println(stack.pop());
                break;
            }
        }

    }*/
}
