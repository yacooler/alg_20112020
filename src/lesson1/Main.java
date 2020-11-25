package lesson1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int a = 5;
//        int b = 5;
//
//        System.out.println(a == b);

//        Person p1 = new Person("Ivan");
//        Person p2 = new Person("Ivan");
//
//        if (p1.equals(p2)) {
//            System.out.println("equals");
//        } else {
//            System.out.println("no equals");
//        }

//        int a = 5;
//        a = inc(a);
//        System.out.println(a);

//        Person p1 = new Person("Ivan");
//        updateName(p1);
//        System.out.println(p1.getName());


//        int[] a = {1, 2, 3};
//        int[] b = {4, 5, 6};
//
//        b = a;
//        a[1] = 999;
//        b[2] = 777;
//
//        System.out.println(Arrays.toString(a));


    }

    private static int method2() {
        int n = 10000;
        int k = 0;
        int[] arr = new int[n];
        for (int i = 0; i < Math.sqrt(n); i++) {
            for (int j = 0; j < Math.sqrt(n); j++) {
                if (arr[i] == arr[j]) {
                    k++;
                }
            }
        }
        return k;
    }

    private static int method1() {
        int n = 10000;
        int k = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 10) {
                k++;
            }
        }
        return k;
    }

    private static boolean isNameBusy(String name) {
        String[] names = new String[1000000];
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void updateName(Person p) {
        p.setName("Super" + p.getName());
    }

    public static int inc(int a) {
        return ++a;
    }
}
