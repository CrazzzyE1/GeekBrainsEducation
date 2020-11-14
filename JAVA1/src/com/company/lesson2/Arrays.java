package com.company.lesson2;

public class Arrays {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArrays(numbers);
        changeArrayNumbers(numbers);
        printArrays(numbers);
        System.out.println();

        int[] eight = new int[8];
        printArrays(eight);
        numbersToArray(eight);
        printArrays(eight);
        System.out.println();

        int[] twelve = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArrays(twelve);
        lessThanSix(twelve);
        printArrays(twelve);
        System.out.println();

        int n = (int) (Math.random() * 10 + 2);
        int[][] matrix = new int[n][n];
        printArrays(matrix);
        inviteOneToMatrix(matrix);
        printArrays(matrix);

        n = (int) (Math.random() * 10 + 100);
        int[] randomArray = new int[n];
        inviteRandomNumbersToArray(randomArray);
        printArrays(randomArray);
        minMaxSearch(randomArray);
        System.out.println();

        int arr1[] = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int arr2[] = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        printArrays(arr1);
        boolean result = leftRightSum(arr1);
        // sout впилил для наглядности =)
        System.out.println(result);
        System.out.println();
        printArrays(arr2);
        result = leftRightSum(arr2);
        System.out.println(result);
        System.out.println();

        n = 10; // размер массива
        double numbersMatrix[] = new double[n];
        n = (int) ((Math.random() * 100) - (Math.random() * 100)); // кол-во сдвигов
        System.out.println("Количество сдвигов: " + n + ", но по факту: " + (n % numbersMatrix.length));
        inviteRandomNumbersToArray(numbersMatrix);
        printArrays(numbersMatrix);
        moveMatrix(numbersMatrix, n);
        printArrays(numbersMatrix);


    }

    public static void moveMatrix(double array[], int n) {

        n %= array.length;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                double tmp = array[0];
                for (int j = 1; j < array.length; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 1] = tmp;
            }
        }
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                double tmp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = tmp;
            }
        }
    }

    public static void inviteRandomNumbersToArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 1000) - (Math.random() * 1000));
        }
    }

    public static boolean leftRightSum(int array[]) {
        int summ = 0;
        int tmp = 0;

        for (int i = 0; i < array.length; i++) {
            summ += array[i];
        }
        if (summ % 2 == 1) return false;
        for (int i = 0; i < array.length; i++) {
            tmp += array[i];

            if (tmp == summ / 2) {
                // sout впилил для наглядности =)
                System.out.println("Граница сумм между элементом: " + (i + 1) + " и " + (i + 2));
                return true;
            }
        }
        return false;
    }

    public static void inviteRandomNumbersToArray(double array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 100) - (Math.random() * 100));
        }
    }


    public static void minMaxSearch(int array[]) {
        int min = array[0];
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }

        System.out.println("MINIMUM is " + min + " MAXIMUM is " + max);
    }

    public static void inviteOneToMatrix(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || (i + j == array.length - 1)) array[i][j] = 1;
            }
        }
    }

    public static void lessThanSix(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
    }

    public static void numbersToArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
    }

    public static void changeArrayNumbers(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
    }

    public static void printArrays(int array[]) {
        for (int i :
                array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printArrays(double array[]) {
        for (double i :
                array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printArrays(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}