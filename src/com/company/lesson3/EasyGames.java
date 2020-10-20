package com.company.lesson3;

import java.util.Arrays;
import java.util.Scanner;


public class EasyGames {
    public static void main(String[] args) {
        System.out.println("Угадай число");
        System.out.println("**************************");
        guessTheNumber();
        System.out.println("**************************");
        System.out.println("Угадай Фрукт");
        fruitBattleGame();
    }

    public static void fruitBattleGame() {
        String[] fruits = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        char[] fieldMagic = new char[15];
        Arrays.fill(fieldMagic, '#');

        String superFruit = fruits[(int) (Math.random() * 25)];
        System.out.println("Бро, настало время угадать, что ты за фрукт!");
        Scanner sc = new Scanner(System.in);
        String userFruit;
        while (true) {
            userFruit = sc.nextLine().trim().toLowerCase();
            if (superFruit.length() == userFruit.length() && superFruit.equals(userFruit)) {
                System.out.println("Congratulations, Bro! Your are " + superFruit.toUpperCase());
                return;
            }
            for (int j = 0; j < superFruit.length() && j < userFruit.length(); j++) {
                if (superFruit.charAt(j) == userFruit.charAt(j)) fieldMagic[j] = superFruit.charAt(j);
            }
            printArray(fieldMagic);
        }
    }

    public static void printArray(char[] ch) {
        for (char c : ch
        ) {
            System.out.print(c);
        }
        System.out.println();
    }


    public static void guessTheNumber() {

        System.out.println();
        System.out.println("Я хочу сыграть с тобой в одну игру...");
        System.out.println("Угадай число от 0 до 9...");
        System.out.println();
        boolean flag = false;
        int answer = 1;
        int result;
        int n = 3;
        Scanner sc = new Scanner(System.in);

        while (answer != 0) {
            int a = (int) (Math.random() * 10);

            System.out.println("Введи число от 0 до 9:");
            for (int i = 0; i < n; i++) {
                System.out.println("Осталось попыток: " + (n - i));

                try {
                    result = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ну просил же вводить числа от 0 до 9!!!! ");
                    return;
                }

                if (result > a) {
                    System.out.println("Бро, я загадал число меньше!");
                } else if (result < a) {
                    System.out.println("Бро, я загадал число больше!");
                } else {
                    System.out.println("Красавчик! Ты угадал!!! Я загадывал число: " + a);
                    flag = true;
                    break;
                }
            }
            System.out.println();
            System.out.println("Сыграем еще раз или слабо?");
            System.out.println("Играем - Нажми 1 **** Слабо - Нажми 0");
            try {
                answer = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Ну просил же вводить числа от 0 до 9!!!! ");
                return;
            }

        }
        if (flag) {
            System.out.println("Я знал, что у тебя получится угадать хотя бы разок! Возвращайся еще!");
        } else {
            System.out.println("Слабак!!! Не хочу тебя больше видеть! Убирайся вон!");
        }

    }
}
