package company.lesson5;

public class Second {

    public void go(float[] arr) throws InterruptedException {

        float[] myArr = new float[arr.length];
        System.arraycopy(arr, 0, myArr, 0, arr.length);
        float[] a1 = new float[test.h];
        float[] a2 = new float[test.h];

        long a = System.currentTimeMillis();
        System.arraycopy(myArr, 0, a1, 0, test.h);
        System.arraycopy(myArr, test.h, a2, 0, test.h);

        Runnable firstHalf = () -> {
            doIt(a1, 0);
        };

        Runnable secondHalf = () -> {
            doIt(a2, test.h);
        };

        Thread t1 = new Thread(firstHalf);
        Thread t2 = new Thread(secondHalf);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(a1, 0, myArr, 0, test.h);
        System.arraycopy(a2, 0, myArr, test.h, test.h);

        System.out.println("Time: " + (System.currentTimeMillis() - a));
    }

    public void doIt(float[] a, int index) {

        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + (i + index) / 5) * Math.cos(0.2f + (i + index) / 5) * Math.cos(0.4f + (i + index) / 2));
        }
    }
}

