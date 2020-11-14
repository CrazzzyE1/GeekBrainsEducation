package com.company.lesson6;

public abstract class Animal {

    protected int lengthRun;
    protected double heightJump;

    public boolean run(int length) {
        System.out.println(length + " " + (length <= lengthRun));
        return length <= this.lengthRun;
    }

    public boolean jump(double height) {
        System.out.println(height + " " + (height <= heightJump));
        return height <= this.heightJump;
    }

}
