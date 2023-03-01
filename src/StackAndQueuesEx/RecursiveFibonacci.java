package StackAndQueuesEx;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursiveFibonacci {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            ArrayDeque<Long> Fibonacci = new ArrayDeque<>();
            long n = Integer.parseInt(input.nextLine());
            System.out.println(getFibonacci(Fibonacci, n));
        }

        private static Long getFibonacci(ArrayDeque<Long> Fibonacci, long n ) {
            if(n < 2){
                return 1L;
            }else {
                Fibonacci.offer(0L);
                Fibonacci.offer(1L);
                for (int i = 0; i < n; i++) {
                    long Sum = Fibonacci.poll()+Fibonacci.peek();
                    Fibonacci.offer(Sum);
                }
            }
            Fibonacci.poll();
            return Fibonacci.peek();
    }

}
