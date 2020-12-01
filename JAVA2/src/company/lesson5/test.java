package company.lesson5;

public class test {
    static final int size = 10_000_000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[size];
        float[] d1;
        float[] d2;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        First first = new First();
        first.go(arr);
        Second second = new Second();
        second.go(arr);
     }
}
