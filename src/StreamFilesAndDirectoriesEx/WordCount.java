package StreamFilesAndDirectoriesEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathWords));
        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLines) {
            String[] wordsOnARow = line.split("\\s+");
            Arrays.stream(wordsOnARow).forEach(word -> {
                countWords.put(word, 0);
            });
        }
        String pathText = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));
        for (String line : allLinesWithText) {
            line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }

            }
        }
        PrintWriter writes = new PrintWriter("result.txt");

        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writes.println(entry.getKey() + " - " + entry.getValue()));
        writes.close();
    }
}
