package java8.src.multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread waiter = new Thread( () -> {
           synchronized (lock){ // takes the lock on lock object
               System.out.println("Thread-1 waiting...");
               try {
                   lock.wait(); //
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
               System.out.println("Thread-1 resumed.");
           }
        });

        Thread notifier = new Thread( () -> {
            synchronized (lock){

                System.out.println("Thread-2 notifying ...");
                lock.notify();
            }
        });

        waiter.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        notifier.start();
    }
}
