package lesson8;

import java.util.Arrays;

public class LinearProbingHashMap<Key, Value> {
    private int capacity = 97;
    private int size;
    private Key EMPTY_CELL;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap() {
        EMPTY_CELL = (Key) new Object();
        keys = (Key[]) new Object[this.capacity];
        values = (Value[]) new Object[this.capacity];
    }

    public LinearProbingHashMap(int capacity) {
        this.capacity = capacity;
        EMPTY_CELL = (Key) new Object();
        keys = (Key[]) new Object[this.capacity];
        values = (Value[]) new Object[this.capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(Key key) {
        return 7- (key.hashCode() & 0x7fffffff) % 7;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }


    public void put(Key key, Value value) {
        checkKeyNotNull(key);

        if (size == capacity - 1) {
            throw new RuntimeException("Переполнено. Лучше тут сделать перехеширование на массив больше");
        }

        int i = hash(key);
        int step = hash2(key);

        //В узел с признаком EMPTY_CELL можно положить новые ключ и значение
        while (!isEmptyCell(i)) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
            i = (i + step) % capacity;
        }

        keys[i] = key;
        values[i] = value;
        size++;
    }


    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);
        int steps = 0;

        //Если нашли ключ с признаком EMPTY_CELL, продолжаем искать до ключа со значением null
        while (keys[i] != null) {
            if (key.equals(keys[i])) {
                return values[i];
            }
            i = (i + step) % capacity;

            //Если пропрыгали весь массив, но не нашли ячейку - выходим, т.к. может не быть ни одной ячейки null
            steps++;
            if (steps == capacity) break;
        }

        return null;
    }

    public Value remove(Key key){
        checkKeyNotNull(key);

        int i = hash(key);
        int step = hash2(key);
        int steps = 0;

        while (!isEmptyCell(i)) {
            if (key.equals(keys[i])) {
                keys[i] = EMPTY_CELL;
                size--;
                return values[i];
            }
            i = (i + step) % capacity;

            //Если пропрыгали весь массив, но не нашли ячейку - выходим
            steps++;
            if (steps == capacity) break;
        }
        return null;
    }

    private boolean isEmptyCell(int cell){
        return keys[cell] == null || keys[cell].equals(EMPTY_CELL);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            builder.append("cell[").append(i).append("] ");
            if (!isEmptyCell(i)) builder.append(keys[i]).append(" ").append(values[i]);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
