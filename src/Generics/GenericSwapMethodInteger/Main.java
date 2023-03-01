package GenericSwapMethodInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SwapInteger<Integer> box = new SwapInteger<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }
        String[] input = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(input[0]);
        int secondIndex = Integer.parseInt(input[1]);
        box.swapElements(firstIndex, secondIndex);

        System.out.println(box.toString());
    }
}
