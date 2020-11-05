package com.company.lesson6;

public class Dog extends Animal {

    private int lengthSwim;

    public Dog() {
        lengthRun = ((int) (Math.random() * 50 + 450));
        lengthSwim = ((int) (Math.random() * 10));
        heightJump = Math.random() * 5 / 10;
    }

    public boolean swim(int length) {
        System.out.println(length + " " + (length <= lengthSwim));
        return length <= lengthSwim;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "lengthRun=" + lengthRun +
                ", lengthSwim=" + lengthSwim +
                ", heightJump=" + heightJump +
                '}';
    }


}
