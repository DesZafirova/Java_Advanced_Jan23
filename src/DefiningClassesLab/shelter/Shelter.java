package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public void add(Animal animal) {
        if (data.size() + 1 <= this.capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        if (getCount() > 0) {
            for (Animal animal : data) {
                if (animal.getName().equals(name)) {
                    data.remove(animal);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {


        data.sort(Comparator.comparingInt(e -> e.getAge()));
        Collections.reverse(data);
        return data.get(0);

    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        Collections.reverse(data);
        data.forEach(e -> sb.append(e.getName() + " " + e.getCaretaker()).append(System.lineSeparator()));
        return sb.toString();
    }


    public int getCount() {
        return data.size();
    }

}
