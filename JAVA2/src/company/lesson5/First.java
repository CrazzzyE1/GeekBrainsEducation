package company.lesson5;

public class First {
    public void go(float[] arr) {
        float myArr[] = new float[arr.length];
        System.arraycopy(arr, 0, myArr, 0, arr.length);

        long a = System.currentTimeMillis();
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = (float) (myArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Time: " + (System.currentTimeMillis() - a));
    }
}
