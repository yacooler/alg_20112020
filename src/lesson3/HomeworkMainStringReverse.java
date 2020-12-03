package lesson3;

import java.util.Scanner;

public class HomeworkMainStringReverse {

    public static void main(String[] args) {
        run();
    }

    private static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для разворота или 1 и enter");

        String str = scanner.next();

        if (str.equals("1")) str = "Каждый охотник знает где сидит фазан";

        System.out.println(reverse(str));
    }

    private static String reverse(String str){
        String[] splited = str.split(" ");
        MyStack<String> stack = new MyStack<>();
        for (String s: splited) {
            stack.push(s);
        }

        int size = stack.size();
        for(int i = 0; i < size; i++){
            splited[i] = stack.pop();
        }

        return String.join(" ", splited);

    }

}
