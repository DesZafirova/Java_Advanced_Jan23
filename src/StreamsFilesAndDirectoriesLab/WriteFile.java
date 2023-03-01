package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.nio.file.LinkPermission;
import java.util.*;

public class WriteFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        String inputPath = path + "\\input.txt";
        String outputPath = path + "\\output.txt";
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '?', '!');


        try (InputStream in = new FileInputStream(inputPath);
             FileOutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                char myByteAsChar = (char) oneByte;
                if(!punctuation.contains(myByteAsChar)){
                    out.write(myByteAsChar);
                }
                oneByte = in.read();

            }
        } catch (IOException e) {

        }
    }

}

