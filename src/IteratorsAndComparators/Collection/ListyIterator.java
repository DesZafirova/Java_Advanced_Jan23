package Collection;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        if (data.isEmpty()) {
            this.index = -1;
        } else {
            this.index = 0;
        }
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public void print() throws Exception {
        if (this.data.isEmpty()) {
            throw new Exception("Invalid Operation!");

        } else {
            System.out.println(this.data.get(this.index));
        }
    }
    public void printAll(){
        this.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;
            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public String next() {
                String element = data.get(index);
                index++;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        this.data.forEach(action::accept);
    }
}
