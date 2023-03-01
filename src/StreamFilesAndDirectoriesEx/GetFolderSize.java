package StreamFilesAndDirectoriesEx;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        File[] allFilesInFolder = folder.listFiles();
        if (allFilesInFolder != null) {
            int folderSize = 0;
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
            System.out.println("Folder size: " + folderSize);
        }
    }
}
