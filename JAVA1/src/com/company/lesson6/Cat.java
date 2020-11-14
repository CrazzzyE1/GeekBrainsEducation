package com.company.lesson6;

public class Cat extends Animal {

    public Cat() {
        lengthRun = ((int) (Math.random() * 50 + 150));
        heightJump = Math.random() * 2;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "lengthRun=" + lengthRun +
                ", heightJump=" + heightJump +
                '}';
    }
}
