package java8.src.multithreading;

public class SynchronizationExample {

    //dummy object variable for synchronization
    private static  Object mutex=new Object();

    public static void main(String[] args) {
        int count =0 ;
        //using synchronized block to read, increment and update count value synchronously
        synchronized (mutex) {
            count++;
        }
    }
}
