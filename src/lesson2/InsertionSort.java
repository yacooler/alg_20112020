package lesson2;

import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    public InsertionSort() {
    }

    public InsertionSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = arrayToSort[i];
            while (j > 0 && comparator.compare(key, arrayToSort[j - 1]) < 0) {
                arrayToSort[j] = arrayToSort[j - 1];
                j--;
            }
            arrayToSort[j] = key;
        }
    }

}
