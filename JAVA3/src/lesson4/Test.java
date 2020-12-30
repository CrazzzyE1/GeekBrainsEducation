package lesson4;

public class Test {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread tr1 = new Thread(new SynchroThread(lock, 'A'));
        Thread tr2 = new Thread(new SynchroThread(lock, 'B'));
        Thread tr3 = new Thread(new SynchroThread(lock, 'C'));

        tr1.start();
        tr2.start();
        tr3.start();

    }
}
