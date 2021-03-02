package lesson7;

public class ExamplesForTest {


//    1. Создать класс, который может выполнять «тесты», в качестве тестов
//    выступают классы с наборами методов с аннотациями @Test.
//    Для этого у него должен быть статический метод start(),

//    которому в качестве параметра передается или объект типа Class,

//    или имя класса. Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite,
//    если такой имеется, далее запущены методы с аннотациями @Test, а по завершению всех тестов –
//    метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
//    в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения.
//    Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе необходимо
//    бросить RuntimeException при запуске «тестирования».


    @MyTest(priority = 1)
    public static void test1() {
        System.out.println("test 1");
    }

    @BeforeSuite
    public static void test2() {
        System.out.println("test 2");
    }

    @MyTest(priority = 1)
    public static void test3() {
        System.out.println("test 3");
    }

    @MyTest(priority = 2)
    public static void test4() {
        System.out.println("test 4");
    }

    @AfterSuite
    public static void test5() {
        System.out.println("test 5");
    }

    @MyTest(priority = 9)
    public static void test6() {
        System.out.println("test 6");
    }

    @MyTest(priority = 1)
    public static void test7() {
        System.out.println("test 7");
    }
}
