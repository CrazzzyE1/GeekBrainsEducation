package lesson1;

public class MultiFruit {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();
        Box<Apple> box4 = new Box<>();

        for (int i = 0; i < 5; i++) {
            box1.addFruit(new Apple());
            box3.addFruit(new Orange());
            if (i < 4) box2.addFruit(new Orange());
            if (i < 3) box4.addFruit(new Apple());
        }

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());
        System.out.println(box4.getWeight());

        System.out.println(box1.compare(box2));
        System.out.println(box1.compare(box3));
        System.out.println(box2.compare(box3));
        System.out.println(box2.compare(box4));

        box2.changeBox(box3);
        box3.changeBox(box2);
        box1.changeBox(box4);
        box4.changeBox(box1);

    }
}
