package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        return fruits.get(0).getWeight() * fruits.size();
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void changeBox(Box<T> box) {
        for (int i = fruits.size() - 1; i > -1; i--) {
            box.addFruit(fruits.remove(i));
        }
    }
}
