import java.util.Scanner;

public class Demo_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
            return fib(n - 1) + fib(n - 2);

    }

}
