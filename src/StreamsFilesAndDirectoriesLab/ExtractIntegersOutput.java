package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegersOutput {
    public static void main(String[] args) throws FileNotFoundException {

        String input = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";
        Scanner reader = new Scanner(new FileInputStream(input));
        PrintWriter out = new PrintWriter(new FileOutputStream(output));

        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                int myNumber = reader.nextInt();
                //System.out.println(reader.nextInt());
            out.println(myNumber);
            }
            reader.next();
        }
out.close();
    }


}
