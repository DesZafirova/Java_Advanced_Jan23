package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class SwapBox<T> {
    private List<T> elements;
    public SwapBox(){
        this.elements = new ArrayList<>();
    }
    public void add(T element){
        this.elements.add(element);
    }
    public void swapElements( int indexOne, int indexTwo){
        T firstElement = elements.get(indexOne);
        T secondElement = elements.get(indexTwo);
        elements.set(indexOne, secondElement);
        elements.set(indexTwo, firstElement);

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
