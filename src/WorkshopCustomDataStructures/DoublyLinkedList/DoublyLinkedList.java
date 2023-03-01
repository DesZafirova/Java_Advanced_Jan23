package WorkshopCustomDataStructures.DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.previous = tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public int get(int index) {
        checkValidIndex(index);
        int result = 0;
        if (index <= this.size / 2) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            result = currentNode.currentValue;
        } else {
            Node currentNode = this.tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
            result = currentNode.currentValue;
        }
        return result;
    }

    public int removeFirst(int element) {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        int firstElement = this.head.currentValue;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.previous = null;
        }
        this.size--;
        return firstElement;
    }

    public int removeLast(int element) {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        int lastElement = this.tail.currentValue;
        if (this.size == 1) {
            this.tail = this.head = null;

        }else{
            this.tail = this.tail.previous;
            this.tail.next = null;

        }
        this.size--;
        return lastElement;
    }
    public void forEach(Consumer<Integer> consumer){
        Node node = this.head;
        while(node != null){
            consumer.accept(node.currentValue);
            node = node.next;
        }
    }
    public int[] toArray(){
//        int[] array = new int[this.size];
//        int counter = 0;
//        Node node = this.head;
//        while(node != null){
//            array[counter++] = node.currentValue;
//            node = node.next;
//        }
//        return array;
        List<Integer> resultList = new ArrayList<>();
        forEach(el -> resultList.add(el));
        return resultList.stream().mapToInt(e -> e).toArray();
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= this.size) {
            String massage = String.format("Index %d is out of bounds for size %d", index, this.size);
            throw new IndexOutOfBoundsException(massage);
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

}
