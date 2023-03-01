package StreamFilesAndDirectoriesEx;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Scanner reader = new Scanner((new FileReader(input)));
        List<String> allLines = Files.readAllLines(Path.of(input));
//        for(String line : allLines){
//            int sum = 0;
//            for(char symbol : line.toCharArray()){
//                sum += (int) symbol;
//            }
//            System.out.println(sum);
//        }
        allLines.stream().map(line -> line.toCharArray())//правим реда на масив от символи
                .forEach((arr -> {
                    int sum = 0;
                    for (char symbol : arr){
                        sum+=(int) symbol;
                    }
                    System.out.println(sum);
                }));
    }
}
