package StrategyPattern;



import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> nameSet = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageSet = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] peopleParameters = line.split("\\s+");
            Person person = new Person(peopleParameters[0],Integer.parseInt(peopleParameters[1]) );
            nameSet.add(person);
            ageSet.add(person);
        }
        for (Person person: nameSet){
            System.out.println(person);
        }
        for (Person person : ageSet){
            System.out.println(person);
        }

    }
}
