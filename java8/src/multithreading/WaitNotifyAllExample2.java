package java8.src.multithreading;

public class WaitNotifyAllExample2 {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread t1 = new Thread(new NumberPrinter2("Thread-1", lock, 1, 3));
        Thread t2 = new Thread(new NumberPrinter2("Thread-2", lock, 2, 3));
        Thread t3 = new Thread(new NumberPrinter2("Thread-3", lock, 3, 3));

        t1.start();
        t2.start();
        t3.start();
    }
}

class NumberPrinter2 implements Runnable {
    private final String name;
    private final Object lock;
    private final int threadId;
    private final int totalThreads;
    private static int turn = 1;

    public NumberPrinter2(String name, Object lock, int threadId, int totalThreads) {
        this.name = name;
        this.lock = lock;
        this.threadId = threadId;
        this.totalThreads = totalThreads;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            synchronized (lock) {
                while (turn != threadId) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name + " prints " + i);
                turn = (turn % totalThreads) + 1;
                lock.notifyAll();
            }
        }
    }
}
