import java.util.ArrayDeque;
import java.util.Scanner;

public class demo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] input = scanner.nextLine().toCharArray();
            int counter = 0;


            if (input.length % 2 == 0) {
                for (int i = 0; i <= (input.length / 2) - 1; i++) {

                    stack.push(input[i]);

                }

            } else {
                System.out.println("NO");
                return;
            }

            for (char item : input) {
                if (item == ')' || item == ']' || item == '}') {
                    char lastOpenBracket = stack.pop();
                    if (lastOpenBracket == '(' && item == ')') {
                        counter++;

                    } else if (lastOpenBracket == '[' && item == ']') {
                        counter++;
                    } else if (lastOpenBracket == '{' && item == '}') {
                        counter++;
                    }else{
                        System.out.println("NO");
                        break;
                    }
                }


            }
            if (counter == input.length / 2) {
                System.out.println("YES");
            }
        }
    }
