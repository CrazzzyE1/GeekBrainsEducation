package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        String[] strings = new String[]{"aaa", "bbb", "ccc", "ddd"};
        Integer[] ints = {1, 2, 3, 4};
        Cat[] cats = new Cat[]{new Cat(), new Cat(), new Cat(), new Cat()};

        changePosition(strings, 1, 2);
        changePosition(ints, 2, 3);
        changePosition(cats, 3, 0);

        ArrayList<String> tmp1 = arrToArrayList(strings);
        ArrayList<Integer> tmp2 = arrToArrayList(ints);
        ArrayList<Cat> tmp3 = arrToArrayList(cats);

    }

    public static <T> void changePosition(T[] array, int x, int y) {
        printArray(array);
        if (x < array.length && y < array.length && x > -1 && y > -1) {
            T tmp = array[y];
            array[y] = array[x];
            array[x] = tmp;
            printArray(array);
        } else {
            System.out.println("Invalid index, operation canceled");
        }
    }

    public static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static <T> ArrayList<T> arrToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}

class Cat {
    private static int allId;
    private String name;

    public Cat() {
        allId++;
        this.name = "name#" + allId;
    }

    @Override
    public String toString() {
        return "Cat{" + name + "}";
    }
}


