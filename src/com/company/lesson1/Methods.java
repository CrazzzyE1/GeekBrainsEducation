package com.company.lesson1;

import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа а, b, c, d и свое имя через пробел");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();

        System.out.println(abcdResult(a, b, c, d));

        System.out.println(tenTwentyRange(a, b));
        int x = (int)a;
        int y = (int)b;
        isPositiveNumber(x);

        System.out.println(isNegative(y));

        String name = scanner.nextLine().trim();

        helloName(name);



    }



    public static double abcdResult(double a, double b, double c, double d) {

        return a * (b + (c / d));
    }

    public static boolean tenTwentyRange(double a, double b) {
        return a + b > 10 && a + b <= 20;
    }

    public static void isPositiveNumber(int a) {
        if (a>=0){
            System.out.println("Positive number");
        } else {
            System.out.println("Negative number");
        }
    }

    private static boolean isNegative(int y) {
        return y < 0;
    }

    public static void helloName(String name) {
        System.out.println("«Привет, " + name + "!»");
    }

}
