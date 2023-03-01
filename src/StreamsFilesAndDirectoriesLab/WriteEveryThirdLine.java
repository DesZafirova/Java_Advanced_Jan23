package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";
        Scanner in = new Scanner(new FileReader(input));
        PrintWriter out = new PrintWriter(new FileWriter(output));
        int counter = 1;
        String line = in.nextLine();

        while (in.hasNextLine()) {
            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;
            line =in.nextLine();
        }
        out.close();
    }
}
