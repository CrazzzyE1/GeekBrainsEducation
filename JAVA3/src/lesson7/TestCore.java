package lesson7;

import java.lang.reflect.*;
import java.util.*;


public class TestCore {

    public static void start(Class clazz) {
        Map<Integer, ArrayList<Method>> map = new TreeMap<>();
        ArrayList<Method> arr;
        int priority;
        Method beforeSuite = null;
        int beforeCount = 0;
        int afterCount = 0;
        Method afterSuite = null;
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                beforeSuite = methods[i];
                beforeCount++;
            }
            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                afterSuite = methods[i];
                afterCount++;
            }
            if (methods[i].isAnnotationPresent(MyTest.class)) {
                priority = methods[i].getAnnotation(MyTest.class).priority();
                if (priority < 0) priority = 0;
                if (priority > 10) priority = 9;
                arr = map.get(priority);
                if (arr == null) arr = new ArrayList<>();
                arr.add(methods[i]);
                map.put(priority, arr);
            }
        }
        if (beforeCount > 1) throw new RuntimeException("@Before OLOLO");
        if (afterCount > 1) throw new RuntimeException("@After OLOLO");

        try {
            beforeSuite.invoke(clazz);

            for (int i = 0; i < 10; i++) {
                arr = map.get(i);
                if (arr != null) {
                    for (int j = 0; j < arr.size(); j++) {
                        arr.get(j).invoke(clazz);
                    }
                }
            }

            afterSuite.invoke(clazz);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}


