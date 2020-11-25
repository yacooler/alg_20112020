package lesson2;


import java.util.Comparator;

public class SelectionSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    public SelectionSort() {
        super();
    }

    public SelectionSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare(arrayToSort[j], arrayToSort[iMin]) < 0) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }

    }
}
