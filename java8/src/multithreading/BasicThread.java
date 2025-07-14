package java8.src.multithreading;

public class BasicThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new NumberPrinter("Thread-1"));
        Thread t2 = new Thread(new NumberPrinter("Thread-2"));
        Thread t3 = new Thread(new NumberPrinter("Thread-3"));

        t1.start();
        t2.start();
        t3.start();

        t1.run();
    }
}

class NumberPrinter implements Runnable {
    private final String name;

    public NumberPrinter(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(100); // pauses the current execution of thread
                //Thread.currentThread().wait(); // throws an runtime exception IllegalMonitorStateException: current thread is not owner , because it can only be used in a synchronized block and tries to release the lock
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " prints " + i);
        }
    }
}