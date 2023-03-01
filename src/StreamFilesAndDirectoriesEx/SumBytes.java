package StreamFilesAndDirectoriesEx;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Scanner reader = new Scanner((new FileReader(input)));
        List<String> allLines = Files.readAllLines(Path.of(input));
     long sum = 0;
     for (String line:allLines){
         for (char symbol:line.toCharArray()){
             sum+=symbol;
         }
     }
        System.out.println(sum);
    }
}
