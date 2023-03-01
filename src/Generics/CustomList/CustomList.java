package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        isValidIndex(index);
//            T element = (T)this.data.get(index);
//            this.data.remove(element);
//            return element;
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        for (T e : this.data) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void swapElements(int indexOne, int indexTwo) {
        if (isValidIndex(indexOne) && isValidIndex(indexTwo)) {
            T firstElement = this.data.get(indexOne);
            T secondElement = this.data.get(indexTwo);
            data.set(indexOne, secondElement);
            data.set(indexTwo, firstElement);
        }
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T e : this.data) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < this.data.size();
    }

    public T getMax() {
     //   return Collections.max(this.data);
        return data.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return Collections.min(this.data);
    }

    public void sort() {
        this.data.sort((e1, e2) -> e1.compareTo(e2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.data) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }


}
