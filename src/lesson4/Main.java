package lesson4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {


        /*remove для итератора*/
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("Maria");
        mll.insertFirst("Katya");
        mll.insertFirst("Luba");

        System.out.println(mll);

        Iterator<String> iterator = mll.iterator();
        iterator.next(); //встаем на Любу
        iterator.remove(); //и удаляем её
        //iterator.remove(); //java.lang.IllegalStateException, сперва надо перейти к след. элементу!
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println();

        /*ListIterator*/
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        //ArrayList<String> testList = new ArrayList<>();
        ListIterator<String> listIterator = myLinkedList.listIterator();
        //ListIterator<String> listIterator = testList.listIterator();

        listIterator.add("1Каждый");
        listIterator.add("2Охотник");
        listIterator.add("3Желает");
        listIterator.add("4Знать");
        listIterator.add("5Где");
        listIterator.add("6Сидит");
        listIterator.add("7Фазан");

        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        listIterator.remove();

        System.out.println(myLinkedList);
        //testList.forEach(System.out::println);


//        for (int i = 0; i < 3; i++) {
//            System.out.println(mll.removeFirst());
//        }

//        mll.insertLast("Maria");
//        mll.insertLast("Katya");
//        mll.insertLast("Luba");
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println(mll.removeLast());
//        }


//        System.out.println(mll.indexOf("Maria"));

//        System.out.println(mll);
//        mll.insert(2, "mmm");
//        System.out.println(mll);
//        System.out.println(mll.remove(2));
////        mll.remove("mmm");
//        System.out.println(mll);
//
//        for (String s : mll) {
//            System.out.println(s);
//        }

//        MyQueue<String> mq = new MyQueue<>();
//        mq.enqueue("qwe");
//        mq.enqueue("asd");
//        mq.enqueue("zxc");
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println(mq.dequeue());
//        }

    }
}
