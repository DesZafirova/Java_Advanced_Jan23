package GenericCountMethodDouble;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BoxCountDouble<Double> boxCountDouble = new BoxCountDouble<>();
        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            boxCountDouble.add(input);
        }
        double input = Double.parseDouble(scanner.nextLine());
        System.out.println(boxCountDouble.compare(input));
    }
}
