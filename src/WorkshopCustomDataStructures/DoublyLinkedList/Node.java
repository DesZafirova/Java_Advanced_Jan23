package WorkshopCustomDataStructures.DoublyLinkedList;

public class Node {
    public int currentValue;
    public Node next;
    public Node previous;

    public Node(int value) {
        this.currentValue = value;
    }

    @Override
    public String toString() {
        return this.currentValue + "";
    }
}
