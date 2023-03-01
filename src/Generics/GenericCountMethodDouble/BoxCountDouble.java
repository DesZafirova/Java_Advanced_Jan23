package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class BoxCountDouble<T extends Comparable<T>> {
    private List<T> elements;

    public BoxCountDouble() {
        this.elements = new ArrayList<>();
    }
    public void add(T element){
        this.elements.add(element);
    }
    public int compare( T element){
        int count = 0;
        for (T e : elements){
            if(e.compareTo(element) > 0){
                count++;
            }
        }return  count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element :elements){
            sb.append(element.getClass().getName() + ": " + element).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
