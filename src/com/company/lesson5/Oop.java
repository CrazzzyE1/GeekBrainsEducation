package com.company.lesson5;

public class Oop {
    private static final Employee[] employers = new Employee[50];

    public static void main(String[] args) {
        String[] names = new String[]{"Адам", "Александр", "Алексей", "Альберт", "Амир", "Анатолий", "Андрей", "Антон", "Арсений",
                "Артём", "Артемий", "Артур", "Богдан", "Борис", "Вадим", "Валентин", "Валерий", "Василий", "Виктор", "Виталий",
                "Владимир", "Владислав", "Всеволод", "Вячеслав", "Гавриил", "Геннадий", "Георгий", "Герман", "Глеб", "Гордей",
                "Григорий", "Давид", "Дамир", "Даниил", "Даниэль", "Демид", "Денис", "Дмитрий", "Добрыня", "Евгений", "Егор",
                "Елисей", "Ефим", "Захар", "Иван", "Игнат", "Игорь", "Илья", "Казимир", "Ким", "Кирилл", "Клим", "Константин",
                "Лев", "Леонид", "Макар", "Максим", "Марат", "Марк", "Марсель", "Матвей", "Мирон", "Мирослав", "Михаил", "Назар",
                "Никита", "Николай", "Олег", "Остап", "Павел", "Пётр", "Платон", "Роберт", "Родион", "Роман", "Ростислав", "Руслан",
                "Савва", "Савелий", "Святослав", "Семён", "Серафим", "Сергей", "Станислав", "Степан", "Тарас", "Тимофей", "Тимур",
                "Тихомир", "Тихон", "Фёдор", "Филипп", "Эдуард", "Эльдар", "Эмиль", "Эрик", "Юрий", "Яков", "Ян", "Ярослав"};
        String[] surnames = new String[]{"Воробьев ", "Павлов", "Михайлов", "Медведев", "Захаров", "Тарасов", "Смирнов", "Виноградов",
                "Гусев", "Кузнецов", "Васильев", "Романов", "Егоров", "Фролов", "Антонов", "Морозов", "Яковлев", "Григорьев", "", "Дмитриев",
                "Орлов", "Сорокин", "Ковалев", "Поляков", "Александров", "Соколов", "Федоров", "Кузьмин", "Зайцев", "Ильин", "Семенов",
                "Борисов", "Киселев", "Сергеев", "Максимов", "Волков", "Соловьев", "Макаров", "Новиков", "Лебедев", "Алексеев", "Иванов",
                "Попов", "Петров", "Степанов", "Николаев", "Козлов", "Королев", "Никитин", "Белов", "Андреев"};
        String[] positions = new String[]{"Инженер", "Повар", "Бухгалтер"};


        for (int i = 0; i < employers.length; i++) {
            String name = names[(int) (Math.random() * names.length)];
            String surname = surnames[(int) (Math.random() * surnames.length)];
            String position = positions[(int) (Math.random() * positions.length)];
            String email = name + surname + "@mail.ru";
            String phone = "+7-920-" + (int) (Math.random() * 500 + 100) + "-" + (int) (Math.random() * 90 + 10) + "-" + (int) (Math.random() * 90 + 10);
            int salary = ((int) (Math.random() * 25)) * 1000 + 50000;
            int age = (int) (Math.random() * 40 + 18);
            employers[i] = new Employee(name, surname, position, email, phone, salary, age);
        }


        oldEmployee(40);

        System.out.println();
        System.out.println();
        System.out.println("My Array");
        System.out.println();

        System.out.println("Create Array");
        IntArray myArr = new IntArray();
        for (int i = 0; i < 9; i++) {
            myArr.add(i);
        }
        myArr.arrInfo();

        System.out.println("ADD 9 to Array");
        myArr.add(9);
        myArr.arrInfo();

        System.out.println("ADD -5 to index 7");
        myArr.add(7, -5);
        myArr.arrInfo();

        System.out.println("REMOVE index 7");
        myArr.remove(7);
        myArr.arrInfo();

        System.out.println("REMOVE from 3 to 6");
        myArr.remove(3, 6);
        myArr.arrInfo();

        System.out.println("GET index 3");
        System.out.println(myArr.get(3));
        myArr.arrInfo();

        System.out.println("GET Array length");
        System.out.println("Length is: " + myArr.length());
        myArr.arrInfo();

        System.out.println("ADD to Array Extra Capacity");
        for (int i = 0; i < 250; i++) {
            myArr.add(111);
        }
        myArr.arrInfo();
    }

    public static void oldEmployee(int age) {
        for (Employee employer : employers) {
            if (employer.getAge() >= age) {
                System.out.println(employer.toString());
            }
        }
    }
}
