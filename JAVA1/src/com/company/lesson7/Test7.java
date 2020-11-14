package com.company.lesson7;

public class Test7 {
    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Barsiik " + i, i * 2 + 6);
        }

        Plate plate = new Plate(100);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        plate.info();

        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }

        plate.replenishPlate(500);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        plate.info();

    }
}
