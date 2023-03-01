package GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SwapBox<String> swapBox = new SwapBox<>();
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            swapBox.add(inputLine);
        }
        String[] input = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(input[0]);
        int secondIndex = Integer.parseInt(input[1]);
        swapBox.swapElements(firstIndex, secondIndex);
        System.out.println(swapBox.toString());
    }
}
