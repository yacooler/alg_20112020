package lesson2;

import java.util.Comparator;

public class BubbleSort <T extends Comparable<T>> extends SortAlgorithm<T> {

    public BubbleSort() {
    }

    public BubbleSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arrayToSort[j + 1], arrayToSort[j]) < 0) {
                    swap(j, j + 1);
                    isSwap = true;
                }

            }
            if (!isSwap) {
                break;
            }
        }
    }

}
