package SetsAndMapsLab;

import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();
        String[] inputOne = scanner.nextLine().split(" ");
        for (int i = 0; i < inputOne.length; i++) {
            int current = Integer.parseInt(inputOne[i]);
            deckOne.add(current);
        }


        String[] inputTwo = scanner.nextLine().split(" ");
        for (int i = 0; i < inputTwo.length; i++) {
            int current = Integer.parseInt(inputTwo[i]);
            deckTwo.add(current);
        }

        Iterator<Integer> iteratorOne = deckOne.iterator();
        Iterator<Integer> iteratorTwo = deckTwo.iterator();


        for (int i = 0; i < 50; i++) {
            Integer fighterOne = deckOne.iterator().next();
            Integer fighterTwo = deckTwo.iterator().next();
            deckOne.remove(fighterOne);
            deckTwo.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                deckOne.add(fighterOne);
                deckOne.add(fighterTwo);
            } else if (fighterOne < fighterTwo){
                deckTwo.add(fighterOne);
                deckTwo.add(fighterTwo);
            }else {
                deckOne.add(fighterOne);
                deckTwo.add(fighterTwo);
            }
            if (deckOne.isEmpty() || deckTwo.isEmpty()){
                break;
            }

        }

        if(deckTwo.size() < deckOne.size()){
            System.out.println("First player win!");
        } else if (deckOne.size() < deckTwo.size()) {
            System.out.println("Second player win!");
        } else  {
            System.out.println("Draw!");
        }
    }
}
