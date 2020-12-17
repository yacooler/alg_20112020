package lesson8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        checkChainRemove();
        checkLinearRemove();
    }

    private static void checkLinearRemove() {
        LinearProbingHashMap<Integer, String> lhm = new LinearProbingHashMap<>(5);
        lhm.put(1, "one");
        lhm.put(2, "two");
        lhm.put(3, "three");
        //6 должна встать в ячейку 1 при ёмкости 5, но встанет в 4, т.к. это единственное свободное место
        lhm.put(6, "six");

        System.out.println(lhm);

        //Удалим ячейку 3 и поищем 6
        lhm.remove(3);
        System.out.println(lhm);
        System.out.println(lhm.get(6));

        //Ищем несуществующий ключ
        System.out.println(lhm.get(0));
    }

    private static void checkChainRemove() {
        System.out.println("CHAIN REMOVE");
        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>(3);

        chm.put(1, "one");
        chm.put(2, "two");
        chm.put(3, "three");
        chm.put(4, "four");
        chm.put(5, "five");
        chm.put(6, "six");
        chm.put(7, "seven");

        System.out.println(chm);
        chm.remove(3);
        chm.remove(2);
        chm.remove(5);
        System.out.println(chm);

        //Ищем несуществующий ключ
        System.out.println(chm.get(0));
    }
}
