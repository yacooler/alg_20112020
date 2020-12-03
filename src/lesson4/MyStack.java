package lesson4;

import java.util.EmptyStackException;

public class MyStack<T> {
    private final MyLinkedList<T> stack;

    public MyStack(){
        stack = new MyLinkedList<>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public T peek(){
        if (isEmpty()) throw new EmptyStackException();
        return stack.getFirst();
    }

    public T push(T item){
        stack.insertFirst(item);
        return item;
    }

    public T pop(){
        if (isEmpty()) throw new EmptyStackException();
        return stack.removeFirst();
    }

    public int search(T element){
        return stack.indexOf(element);
    }
}
