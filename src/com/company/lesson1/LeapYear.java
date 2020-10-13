package com.company.lesson1;

import java.util.Scanner;

public class LeapYear {

    //Home work is complete!

    public static void main(String[] args) {
        System.out.println("Введите год для проверки:");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        isLeapYear(year);
    }

    public static void isLeapYear(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println("Год " + year + " является Високосным!");
        } else {
            System.out.println("Год " + year + " является Невисокосным!");
        }
    }
}
