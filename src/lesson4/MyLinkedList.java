package lesson4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;



    public MyLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.getValue();
    }

    public T removeFirst() {
        T oldFirst = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return oldFirst;
    }

    public T removeLast() {
        T oldLast = getLast();
        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrev();
        size--;
        return oldLast;
    }

    public final int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }
        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        newNode.setPrev(current);
        current.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        T temp = current.getValue();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return temp;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;
    }

    private boolean remove(Node node){
        if (isEmpty()) return false;

        if (first.equals(node)){
            removeFirst();
        } else if(last.equals(node)){
            removeLast();
        }

        Node current = first;

        while (current != null && !current.equals(node)){
            current = current.getNext();
        }

        if (current == null) return false;

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;

    }

    /*Добавляет новую ноду между имеющимися*/
    private Node insertBetween(Node prev, Node next, T value){
        Node inserted = new Node(prev, next, value);
        size++;
        return inserted;
    }


    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue() + ", ");
            current = current.getNext();
        }
        if (!isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }



    /*Итератор*/
    private class Iter implements Iterator<T> {
        Node current;
        Node next;

        public Iter(){
            current = new Node(first, null );
            next = first;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            current = next;
            next = current.getNext();
            return current.getValue();
        }

        @Override
        public void remove() {
            if (current == null) throw new IllegalStateException();
            MyLinkedList.this.remove(current);
            current = null;
        }
    }

    /*ЛистИтератор*/
    private class ListIter implements ListIterator<T>{
        Node previous;
        Node current;
        Node next;
        int nextIndex;

        public ListIter(){
            previous = null;
            if (first != null) {
                current = new Node(first, null);
                next = first;
            } else {
                current = null;
                next = null;
            }

            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return (next != null);
        }

        @Override
        public T next() {
            current = next;
            previous = current.getPrev();
            next = current.getNext();
            nextIndex++;
            return current.getValue();
        }

        @Override
        public boolean hasPrevious() {
            return (previous != null);
        }

        @Override
        public T previous() {
            current = previous;
            previous = current.getPrev();
            next = current.getNext();
            nextIndex--;
            return current.getValue();
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (current == null) throw new IllegalStateException();
            MyLinkedList.this.remove(current);
            current = null;
        }

        @Override
        public void set(T t) {
            if (isEmpty() || current == null) throw new IllegalStateException();
            current.setValue(t);
        }

        @Override
        public void add(T t) {

            if (isEmpty()){
                insertFirst(t);
                previous = first;
                nextIndex++;
                return;
            }

            previous = MyLinkedList.this.insertBetween(previous, current, t);


        }
    }

    /*Элемент списка, недоступен снаружи*/
    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T item) {
            this.value = item;
        }

        public Node(Node next, T item) {
            this.value = item;
            this.next = next;
            if (next != null) next.prev = this;
        }

        public Node(Node prev, Node next, T value) {
            this.value = value;

            if (next != null) {
                next.prev = this;
                this.next = next;
            }

            if (prev != null) {
                prev.next = this;
                this.prev = prev;
            }
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

}
