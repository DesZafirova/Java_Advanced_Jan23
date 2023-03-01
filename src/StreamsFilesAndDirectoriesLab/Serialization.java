package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class Serialization {

    public class NestedFolders {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            Cube cube = new Cube("blue", 1, 1, 1);
            String path = "C:\\Users\\desza\\IdeaProjects\\Java_Advanced_Jan23\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\myCube.ser";

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(cube);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            Cube cubeFromFile = (Cube)objectInputStream.readObject();
            System.out.println();
        }
    }

}
