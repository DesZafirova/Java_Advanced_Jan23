package OpinionPoll;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();


        for (int i = 0; i < n; i++) {

            String[] currentPerson = scanner.nextLine().split("\\s+");
            String name = currentPerson[0];
            int age = Integer.parseInt(currentPerson[1]);
            Person person = new Person(name, age);
            personList.add(person);
        }
        personList = personList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());
        for (Person person: personList){
            System.out.println(person.toString());
        }
    }
}
