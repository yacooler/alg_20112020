package lesson5;

public class Main {
    public static void main(String[] args) {

        //Возведение в степень
        System.out.print("pow(2,8) = ");
        System.out.println(pow(2,8));
        System.out.println();


        //Рюкзак
        Knapsack knapsack = new Knapsack();
        knapsack.add("Книга Философия Java", 0.75F, 760F);
        knapsack.add("Консервированный тунец", 0.200F, 300F);
        knapsack.add("Пятикилограмовая гантеля", 5.0F, 2300F);
        knapsack.add("Снежный краб", 1.0F, 12000F);
        knapsack.add("Макароны", 9.0F, 2000F);
        knapsack.add("Видеокарта", 0.7F, 13000F);
        knapsack.add("Машинка для стрижки волос", 0.4F, 900F);
        knapsack.add("Перчатки", 0.150F, 600F);
        knapsack.add("Пакет мусора", 2.0F, 10F);
        knapsack.add("Диски от старой приставки", 2.0F, 300F);
        knapsack.add("Маленький набор инструментов", 2.0F, 3200F);
        knapsack.add("Монитор", 6.0F, 13900F);
        knapsack.add("Мультитул", 0.250F, 5680F);
        knapsack.add("Бутылка виски", 0.70F, 4250F);
        knapsack.add("Мраморная говядина", 2.0F, 1900F);
        knapsack.add("Пачка сторублевых купюр", 0.03F, 10000F);
        knapsack.add("Сломанный принтер", 3.700F, 2500F);


        knapsack.calcAndPrint(10F);




    }

    public static long pow(long num, int pow){
        return recPow(num, pow);
    }

    private static long recPow(long num, int pow){
        //Базовый случай
        if (pow == 0) return 1;
        //рекурентный случай
        return recPow(num, pow - 1) * num;
    }


//        System.out.println(fact(15));

//        System.out.println(recFact(10));
//        System.out.println(fibo(46));

//        System.out.println(recFibo(10));
//        System.out.println(triangleNum(5));
//        System.out.println(recTriangleNum(5));
//
//        System.out.println(multiply(3, 8));
//        System.out.println(recMultiply(3, 8));
//
//    }
//
//    public static int fact(int n) {
//        int value = 1;
//        for (int i = 1; i <= n; i++) {
//            value *= i;
//        }
//        return value;
//    }
//
//    public static int recFact(int n) {
//        if (n <= 1) {
//            return 1;
//        }
//        return recFact(n - 1) * n;
//    }
//
//    public static long fibo(int n) {
//        long a = 1;
//        long b = 1;
//        for (int i = 3; i <= n; i++) {
//            b = b + a;
//            a = b - a;
//        }
//        return b;
//    }
//
//    public static long recFibo(int n) {
//        System.out.print(n + " ");
//        if (n <= 2) {
//            return 1;
//        }
//        return recFibo(n - 2) + recFibo(n - 1);
//    }
//
//    public static int triangleNum(int n) {
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            sum += i;
//        }
//        return sum;
//    }
//
//    public static int recTriangleNum(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        return recTriangleNum(n - 1) + n;
//    }
//
//    public static int multiply(int a, int b) {
//        int value = 0;
//        for (int i = 0; i < b; i++) {
//            value += a;
//        }
//        return value;
//    }
//
//    public static int recMultiply(int a, int b) {
//        if (b == 1) {
//            return a;
//        }
//        return recMultiply(a, b - 1) + a;

//    }

}