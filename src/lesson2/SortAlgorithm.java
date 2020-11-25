package lesson2;

import java.util.Comparator;


public abstract class SortAlgorithm<T extends Comparable<T>> {

    protected T[] arrayToSort;
    protected Comparator<T> comparator;
    protected int size;

    public SortAlgorithm() {
        this.comparator = Comparator.naturalOrder();
    }

    public SortAlgorithm(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void setArrayToSort(T[] arrayToSort, int size){
        this.arrayToSort = arrayToSort;
        this.size = size;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    protected void swap(int index1, int index2){
        T temp = arrayToSort[index1];
        arrayToSort[index1] = arrayToSort[index2];
        arrayToSort[index2] = temp;
    }

    public void sort(){
        sort(comparator);
    };

    public abstract void sort(Comparator<T> comparator);


}
