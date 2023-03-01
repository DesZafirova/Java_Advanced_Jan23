package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";
        Path in = Paths.get(input);
        Path out =Paths.get(output);
        List<String> lines = Files.readAllLines(in);
        Collections.sort(lines);
        Files.write(out, lines);

    }
}
