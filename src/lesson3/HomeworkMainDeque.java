package lesson3;


public class HomeworkMainDeque {

    public static void main(String[] args) {
        run();

    }

    private static void run(){
        MyDeque<String> deque = new MyDeque<>();

        for (int i = 0; i < 10 ; i++) {
            deque.insertLeft(Integer.toString(i));
        }

        System.out.println(deque);

        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());

        System.out.println(deque);

        deque.insertLeft("L");
        deque.insertRight("R");

        System.out.println(deque);

        System.out.println(deque.removeRight());

        System.out.println(deque);
    }

}
