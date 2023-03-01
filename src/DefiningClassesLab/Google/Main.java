package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String information = scanner.nextLine();
        Map<String, Person> peopleData = new HashMap<>();
        while (!information.equals("End")) {
            String[] parts = information.split("\\s+");
            String name = parts[0];
            String type = parts[1];
            if (!peopleData.containsKey(name)){
                peopleData.put(name, new Person());
            }
            switch (type) {
                case "company":
                    String companyName = parts[2];
                    String department = parts[3];
                    double salary = Double.parseDouble(parts[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = parts[2];
                    String pokemonType = parts[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleData.get(name).getPokemons(pokemon).add(pokemon);
                    break;
                case "parents":
                    String parentName = parts[2];
                    String parentBirthday = parts[3];
                    Parents parents = new Parents(parentName, parentBirthday);
                    peopleData.get(name).getParents(parents).add(parents);
                    break;
                case "children":
                    String childName = parts[2];
                    String childbirthday = parts[3];
                    Children children = new Children(childName, childbirthday);
                    peopleData.get(name).getChildren(children).add(children);
                    break;
                case "car":
                    String carModel = parts[2];
                    int carPower = Integer.parseInt(parts[3]);
                    Car car = new Car(carModel, carPower);
                    peopleData.get(name).setCar(car);
                    break;
            }

            information = scanner.nextLine();
        }
        String searchPerson = scanner.nextLine();
        System.out.println(searchPerson);
        Person personalData = peopleData.get(searchPerson);
        System.out.println(personalData);

    }
}
