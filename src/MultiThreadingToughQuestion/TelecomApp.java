package MultiThreadingToughQuestion;

import java.util.ArrayList;
import java.util.List;

public class TelecomApp {

    public static void main(String[] args) {

        CallQueue queue = new CallQueue();

        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1, "Amit", "9991", 100));
        customers.add(new Customer(2, "Rahul", "9992", 50));
        customers.add(new Customer(3, "Priya", "9993", 80));

        Thread producer1 = new Thread(new Producer(queue, customers));
        Thread producer2 = new Thread(new Producer(queue, customers));

        Thread consumer1 = new Thread(new Consumer(queue, customers));
        Thread consumer2 = new Thread(new Consumer(queue, customers));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
