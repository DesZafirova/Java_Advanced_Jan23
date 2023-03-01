package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        int countAllPeople = 0;
        while (!input.equals("END")) {
            String[] inArr = input.split("\\s+");
            String name = inArr[0];
            int age = Integer.parseInt(inArr[1]);
            String town = inArr[2];
            Person person = new Person(name, age, town);
            people.add(person);
            countAllPeople++;
            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        int personIndex = n - 1;
        if (personIndex < 0 || personIndex > people.size() - 1) {
            throw new IndexOutOfBoundsException("INVALID INDEX");
        }
        Person searchedPerson = people.get(n - 1);
        people.remove(n - 1);
        int count = 0;
        for (Person person : people) {
            if (searchedPerson.compareTo(person) == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d\n", count + 1, countAllPeople - (count + 1), countAllPeople);
        }

    }
}
