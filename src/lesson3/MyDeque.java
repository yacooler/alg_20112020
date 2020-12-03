package lesson3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyDeque<T> {

    private final int DEFAULT_CAPACITY = 10;//Емкость по умолчанию
    private final float GROW_FACTOR = 1.3F; //Во сколько раз увеличивать массив при превышении FILL_FACTOR
    private final float FILL_FACTOR = 0.9F; //Заполненность массива, при котором следует его увеличить

    private int size;           //Количество элементов в деке
    private int capacity;       //Вместимость дека

    private int leftInsertCell; //Ячейка, в которую будет вставлен новый элемент слева
    private int rightInsertCell;//Ячейка, в которую будет вставлен новый элемент справа

    private int growCap;        //При превышении данного количества элементов массив list будет расширен

    private Object[] list;

    public MyDeque() {
        init(DEFAULT_CAPACITY);
    }

    public MyDeque(int capacity) {
        init(capacity);
    }

    private void init(int capacity){
        this.capacity = capacity;
        list = new Object[capacity];
        leftInsertCell = capacity / 2;
        rightInsertCell = capacity / 2 + 1;
        growCap = (int) (capacity * FILL_FACTOR);
    }

    public void insertLeft(T item){
        if (size >= growCap) recapacity();
        list[leftInsertCell] = item;
        leftInsertCell = nextLeft(leftInsertCell);
        size++;
    }

    public void insertRight(T item){
        if (size >= growCap) recapacity();
        list[rightInsertCell] = item;
        rightInsertCell = nextRight(rightInsertCell);
        size++;
    }

    public T removeLeft(){
        if (isEmpty()) throw new NoSuchElementException();

        leftInsertCell = nextRight(leftInsertCell);

        Object ret = list[leftInsertCell];
        list[leftInsertCell] = null;

        size--;

        return (T) ret;
    }

    public T removeRight(){
        if (isEmpty()) throw new NoSuchElementException();
        rightInsertCell = nextLeft(rightInsertCell);
        Object ret = list[rightInsertCell];
        list[rightInsertCell] = null;
        size--;
        return (T) ret;
    }

    public T peekLeft(){
        if (isEmpty()) throw new NoSuchElementException();
        return (T) list[nextRight(leftInsertCell)];
    }

    public T peekRight(){
        if (isEmpty()) throw new NoSuchElementException();
        return (T) list[nextLeft(rightInsertCell)];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyDeque{");
        sb.append("leftMoveCell=").append(leftInsertCell);
        sb.append(", rightMoveCell=").append(rightInsertCell);
        sb.append(", list=").append(Arrays.toString(list));
        sb.append('}');
        return sb.toString();
    }

    private int nextLeft(int cell){
        cell--;
        if (cell < 0) cell = capacity - 1;
        return cell;
    }

    private int nextRight(int cell){
        cell++;
        if (cell == capacity) cell = 0;
        return cell;
    }

    private void recapacity(){
        int newCapacity = (int) (GROW_FACTOR * capacity);
        int shift = (newCapacity - capacity) / 2;
        Object newList[] = new Object[newCapacity];

        if (leftInsertCell < rightInsertCell){
            //Натуральный порядок копирования - левая ячейка слева, правая - справа
            System.arraycopy(list, 0, newList, shift, list.length);
        } else {
            //Левая ячейка справа, правая - слева. Развернем массив в натуральный порядок
            System.arraycopy(list, leftInsertCell + 1, newList, shift, capacity - (leftInsertCell + 1) );
            System.arraycopy(list, 0, newList, shift + capacity - (leftInsertCell + 1), rightInsertCell);
        }

        leftInsertCell = shift - 1;
        rightInsertCell = shift + size;
        capacity = newCapacity;
        list = newList;

        //В следующий раз растем при новом значении growGap
        growCap = (int) (capacity * FILL_FACTOR);

    }

}
