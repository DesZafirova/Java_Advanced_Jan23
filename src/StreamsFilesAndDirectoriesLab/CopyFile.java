package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\03.CopyBytesOutput.txt";

        InputStream in = new FileInputStream(inputPath);
             FileOutputStream out = new FileOutputStream(outputPath);

            int oneByte = in.read();
            while (oneByte>=0){

                if(oneByte == 32 || oneByte==10){
                    out.write((char)oneByte);
                } else{
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }

                oneByte = in.read();
            }



    }
}
