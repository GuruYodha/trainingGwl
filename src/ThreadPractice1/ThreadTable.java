package ThreadPractice1;

public class ThreadTable {

    public static void main(String[] args) throws InterruptedException {
        
        Runnable tableOf2 = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread: " + Thread.currentThread().getName() + " - 2 x " + i + " = " + (2 * i));
            }
        };
        
        Runnable tableOf5 = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread: " + Thread.currentThread().getName() + " - 5 x " + i + " = " + (5 * i));
            }
        };
        
        Thread t1 = new Thread(tableOf2, "Table-2-Thread");
        
        Thread t2 = new Thread(tableOf5, "Table-5-Thread");
        
        t1.start();
        t1.join(); // Wait for t1 to finish before starting t2
        t2.start();
    }
}
