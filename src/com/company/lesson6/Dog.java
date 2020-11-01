package com.company.lesson6;

public class Dog extends Animal {

    private final int lengthRun;
    private final int lengthSwim;
    private final double heightJump;

    public Dog() {
        this.lengthRun = ((int) (Math.random() * 50 + 450));
        this.lengthSwim = ((int) (Math.random() * 10));
        this.heightJump = Math.random() * 5 / 10;
    }


    public boolean swim(int length) {
        System.out.println(length + " " + (length <= lengthSwim));
        return length <= lengthSwim;
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
        return "Dog{" +
                "lengthRun=" + lengthRun +
                ", lengthSwim=" + lengthSwim +
                ", heightJump=" + heightJump +
                '}';
    }

    public int getLengthRun() {
        return lengthRun;
    }

    public int getLengthSwim() {
        return lengthSwim;
    }

    public double getHeightJump() {
        return heightJump;
    }
}
