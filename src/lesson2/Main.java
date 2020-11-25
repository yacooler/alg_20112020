package lesson2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int ARRAY_SIZE = 1_000_000;
        int TESTS_COUNT = 1;

        Random random = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            mal.add(i, 0);
        }


        SortAlgorithm[] sortAlgorithms = new SortAlgorithm[]{
                new SelectionSort<Integer>(),
                new BubbleSort<Integer>(),
                new InsertionSort<Integer>()
        };


        //Результаты замеров
        long results[][] = new long[TESTS_COUNT][sortAlgorithms.length];

        long start;
        long finish;

        for (int i = 0; i < TESTS_COUNT; i++) {
            System.out.println(i);
            for (int j = 0; j < sortAlgorithms.length; j++) {

                //Перезаписываем массив
                for (int r = 0; r < ARRAY_SIZE; r++) {
                    mal.set(r, random.nextInt(100));
                }

                System.out.printf("Алгоритм %s запущен\n", sortAlgorithms[j].getClass().getName());
                start = System.nanoTime();
                mal.setSortAlgorithm(sortAlgorithms[j]).sort();
                finish = System.nanoTime();
                System.out.printf("Алгоритм %s отработал\n", sortAlgorithms[j].getClass().getName());

                results[i][j] = finish - start;


            }

        }

        double[] testsTotalResult = new double[sortAlgorithms.length];
        for (int j = 0; j < testsTotalResult.length; j++){
            testsTotalResult[j] = 0;
            for (int i = 0; i < TESTS_COUNT; i++){
                testsTotalResult[j] += results[i][j];
            }
            testsTotalResult[j] /= 1_000_000_000;

            System.out.printf("Алгоритм %s отработал за %.2f секунд\n", sortAlgorithms[j].getClass().getName(), testsTotalResult[j]);
        }





//        System.out.println(mal);
//        mal.selectionSort(Comparator.naturalOrder());
//        mal.selectionSort(Comparator.reverseOrder());
//        mal.selectionSort((a,b)->{return a%10 - b %10;});

//        mal.insertionSort();
//        mal.bubbleSort();
//        System.out.println(mal);
    }
}
