package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new BufferedReader(new InputStreamReader(System.in))
                .lines().collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Party!")) {
            String command = inputLine.split(" ")[0];
            String secondCommand = inputLine.split(" ")[1];


            switch (secondCommand) {
                case "StartsWith":
                    String str = inputLine.split(" ")[2];
                    if (command.equals("Remove")) {

                    } else if (command.equals("Double")) {

                    }
                    break;
                case "EndsWith":
                    if (command.equals("Remove")) {

                    } else if (command.equals("Double")) {

                    }

                    break;
                case "Length":
                    if (command.equals("Remove")) {

                    } else if (command.equals("Double")) {

                    }

                    break;
            }


            inputLine = scanner.nextLine();
        }


    }
}

