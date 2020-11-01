package com.company.lesson6;

public class Cat extends Animal{
    private final int lengthRun;
    private final double heightJump;

    public Cat() {
        this.lengthRun = ((int) (Math.random() * 50 + 150));
        this.heightJump = Math.random() * 2;
    }

    @Override
    public boolean run(int length) {
        System.out.println(length + " " + (length <= lengthRun));
        return length <= lengthRun;
    }

    @Override
    public boolean jump(double height) {
        System.out.println(height + " " + (height <= heightJump));
        return height <= heightJump;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "lengthRun=" + lengthRun +
                ", heightJump=" + heightJump +
                '}';
    }

    public int getLengthRun() {
        return lengthRun;
    }

    public double getHeightJump() {
        return heightJump;
    }
}
