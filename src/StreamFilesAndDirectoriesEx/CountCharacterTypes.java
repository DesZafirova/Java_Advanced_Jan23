package StreamFilesAndDirectoriesEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        PrintWriter writer = new PrintWriter("outputType.txt");
        List<String> list = Files.readAllLines(Path.of(path));
        String vowel = "[a,e,o,u,i]";
        int countVowels = 0;
        int otherSymbols = 0;
        int punctuation = 0;
        for (String line : list) {
            for (char symbol : line.toCharArray()) {
                if (symbol == 'a' || symbol == 'e' || symbol == 'u' || symbol == 'o' || symbol == 'i') {
                    countVowels++;
                } else if (symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?') {
                        punctuation++;

                    
                } else if (symbol != ' ') {
                    otherSymbols++;
                }
            }
        }
        writer.println("Vowels: " + countVowels);

        writer.println("Other symbols: " + otherSymbols);

        writer.println("Punctuation: " + punctuation);
        writer.close();
    }
}
