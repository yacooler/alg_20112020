package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testHeight();
    }

    private static void testHeight(){
        int COUNT = 20; //10_000_000;
        boolean ECHO = false;
        MyTreeMap<Integer, Integer> map;
        int balanced = 0;
        Random random = new Random();
        List<Integer> list;

        for (int i = 1; i <= COUNT; i++) {


            map = new MyTreeMap<>();
            list = new ArrayList<>();
            for (int k = 0; k <= 200; k++) {
                list.add(k - 100);
            }

            int pos;
            while (map.height() < 6 && !list.isEmpty()) {
                pos = random.nextInt(list.size());
                map.put(list.get(pos), list.get(pos));
                list.remove(pos);
            }

            if (ECHO){
                System.out.println("------------Итерация " + i + "------------");
                System.out.println(map);
                System.out.println("Высота " + map.height());
                System.out.println("Размер " + map.size());
                System.out.println("Сбалансировано: " + map.checkHeightBalance());
            }


            if (map.checkHeightBalance()) balanced++;
        }

        System.out.println("--------------------------------------");
        System.out.printf("Всего деревьев %d из них сбалансировано %d, что составляет %.4f%s", COUNT, balanced, 100F * (float) balanced / (COUNT), "%");
    }




}
