package com.company.lesson6;

public class TestLesson6 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.toString());
        dog.run(400);
        dog.swim(8);
        dog.jump(1);

        Dog dog2 = new Dog();
        System.out.println(dog2.toString());

        dog2.run(100);
        dog2.swim(10);
        dog2.jump(0.5);


        Cat cat = new Cat();
        System.out.println(cat.toString());
        cat.run(150);
        cat.jump(2);

        Cat cat2 = new Cat();
        System.out.println(cat2.toString());
        cat2.run(50);
        cat2.jump(1);

    }
}
