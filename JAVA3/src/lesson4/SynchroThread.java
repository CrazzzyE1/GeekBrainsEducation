package lesson4;

public class SynchroThread implements Runnable {
    private final int number;
    private static int iterations;
    private static int counter;
    private static int threadCounter;
    private final Object monitor;
    private final char symbol;

    public SynchroThread(Object monitor, char symbol) {
        this.monitor = monitor;
        this.symbol = symbol;
        number = threadCounter++;
        iterations = 5;
    }

    @Override
    public void run() {
        while (counter != iterations * threadCounter) {
            synchronized (monitor) {
                if (number == counter % threadCounter) {
                    System.out.print(symbol);
                    counter++;
                    monitor.notifyAll();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
