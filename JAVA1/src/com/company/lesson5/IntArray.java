package com.company.lesson5;

public class IntArray {
    private int[] data;
    private int length;
    private int capacity;

    public IntArray() {
        length = 0;
        capacity = 256;
        data = new int[capacity];
    }

    public void add(int element) {

        if (length >= data.length) {
            int[] tmp = new int[capacity];
            for (int i = 0; i < data.length; i++) {
                tmp[i] = data[i];
            }
            capacity += 256;
            data = new int[capacity];
            for (int i = 0; i < tmp.length; i++) {
                data[i] = tmp[i];
            }
        }
        data[length] = element;
        length++;

    }

    public int get(int index) {
        if (index > (length - 1)) {
            return data[index + capacity + 1]; // Вернет Exception так как index не существует
        } else {
            return data[index];
        }
    }

    public int length() {
        return length;
    }

    public void add(int index, int value) {
        if (index > data.length - 1) {
            data[index + capacity + 1] = value;
        } else if (index == length - 1) {
            add(value);
        } else {
            int[] tmp = data;
            data = new int[capacity];
            for (int i = 0; i < index; i++) {
                data[i] = tmp[i];
            }
            data[index] = value;
            length++;
            for (int i = index + 1; i < length; i++) {
                data[i] = tmp[i - 1];
            }
        }
    }

    public void remove(int index) {
        if (index > length - 1) {
            get(index);
        } else {
            for (int i = index + 1; i < length; i++) {
                data[i - 1] = data[i];

            }
            length--;
        }
    }

    public void remove(int from, int to) {
        if (from >= length || to >= length) {
            get(from + capacity + 1);
        } else if (from == to) {
            remove(to);
        } else {
            if (from > to) {
                int tmp = to;
                to = from;
                from = tmp;
            }
            for (int i = to - 1; i >= from; i--) {
                remove(i);
            }
        }
    }

    public void arrInfo() {
        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("Capacity: " + capacity);
        System.out.println("Length: " + length);
        System.out.println();

    }
}
