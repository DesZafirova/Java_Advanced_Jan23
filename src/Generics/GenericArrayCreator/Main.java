package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        String[] stringArray = ArrayCreator.create(String.class, 5, "Desi");
        Integer[] integerArray = ArrayCreator.create(10, 12);;
        System.out.println();
    }
}
