package lesson2;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;

    private int maxCapacity;

    private SortAlgorithm<T> sortAlgorithm;

    //меньше стартовой вместимости ужаться нельзя
    private int startCapacity;

    private final int DEFAULT_CAPACITY = 10;

    //Увеличиваем список при заполненности выше 75%
    private final float FILL_FACTOR_GROW = 0.75F;

    //Уменьшаем список при заполненности ниже 50%, но не ниже startCapacity
    private final float FILL_FACTOR_COMPRESS = 0.5F;

    private final float FILL_FACTOR_MULTIPLIER = 0.25F;


    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        initList(capacity);
    }

    public MyArrayList() {
        initList(DEFAULT_CAPACITY);
    }


    private void initList(int capacity){
        list = (T[]) new Comparable[capacity];
        maxCapacity = capacity;
        startCapacity = capacity;
    }

    public void add(T item) {
        list[size] = item;
        size++;
        checkFillFactor();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index: " + index);
        }
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
    }

    public boolean remove(T item) {
        int k = indexOf(item);
        if (k == -1) {
            return false;
        }
        remove(k);
        return true;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index] = item;
        size++;
        checkFillFactor();
    }

    public T get(int index) {
        checkIndex(index);
        return list[index];
    }

    public void set(int index, T item) {
        checkIndex(index);
        list[index] = item;
    }

    public int size() {
        return size;
    }

    public final int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Увеличивает или уменьшает размер используемого массива при превышении заполнения или опустения
     * массива на FILL_FACTOR_GROW и FILL_FACTOR_COMPRESS соответственно.
     * Размер массива не может быть меньше стартовой вместимости
     */
    private void checkFillFactor(){
        int newCapacity = 0;

        if (size > (maxCapacity * FILL_FACTOR_GROW)) {
            newCapacity = (int) (maxCapacity * (1F + FILL_FACTOR_MULTIPLIER));
        } else if (size < (maxCapacity * FILL_FACTOR_COMPRESS) && (size * (1F - FILL_FACTOR_MULTIPLIER)) > startCapacity){
            newCapacity = (int) (maxCapacity * (1F - FILL_FACTOR_MULTIPLIER));
        } else return;

        //System.out.println("old capacity " + maxCapacity + " new capacity " + newCapacity);
        list = Arrays.copyOf(list, newCapacity);
        maxCapacity = newCapacity;

    }

    public MyArrayList<T> setSortAlgorithm(SortAlgorithm<T> sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
        this.sortAlgorithm.setArrayToSort(list, size);
        return this;
    }

    public void sort(){
        if (sortAlgorithm == null){
            throw new UnsupportedOperationException("Перед вызовом метода sort() необходимо определить алгоритм сортировки методом setSortAlgorithm!");
        }
        sortAlgorithm.sort();
    }

    public void sort(Comparator<T> comparator){
        sortAlgorithm.sort(comparator);
    }
}
