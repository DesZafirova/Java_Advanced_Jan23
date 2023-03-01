package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<String>();
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("END")){
            String[] commandArr = inputLine.split("\\s+");
            String command = commandArr[0];
            switch (command){
                case "Add":
                    String element = commandArr[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandArr[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String containsElement = commandArr[1];
                    System.out.println(customList.contains(containsElement));
                    break;
                case "Swap":
                    int indexOne = Integer.parseInt(commandArr[1]);
                    int indexTwo = Integer.parseInt(commandArr[2]);
                    customList.swapElements(indexOne,indexTwo);
                    break;
                case "Greater":
                    String greaterElement = commandArr[1];
                    System.out.println( customList.countGreaterThan(greaterElement));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.print(customList.toString());
                    break;
                case "Sort":
                    customList.sort();
                    break;

            }

            inputLine = scanner.nextLine();
        }
    }
}
