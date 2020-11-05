package com.company.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean checkFood(int n) {
        return n <= food;
    }

    public void decreaseFood(int n) {
        if (n <= food) {
            System.out.println("N'yam");
            food -= n;
        }
    }

    public void replenishPlate(int n) {
        if (n > 0) {
            food += n;
            System.out.println("The plate is replenished by: " + n);
        }
    }

    public void info() {
        System.out.println("Plate: " + food);
    }
}
