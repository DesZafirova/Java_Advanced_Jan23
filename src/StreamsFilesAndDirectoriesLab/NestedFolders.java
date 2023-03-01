package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.*;

public class NestedFolders {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println(f);
                }
            }
        }
    }
}
