package MultiThreadingToughQuestion;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private CallQueue queue;
    private List<Customer> customers;
    private Random random = new Random();
    private static int requestCounter = 1;

    public Producer(CallQueue queue, List<Customer> customers) {
        this.queue = queue;
        this.customers = customers;
    }

    @Override
    public void run() {

        try {
            while (true) {

                Customer customer =
                        customers.get(random.nextInt(customers.size()));

                int minutes = random.nextInt(5) + 1;

                CallRequest request = new CallRequest(
                        requestCounter++,
                        customer.getPhoneNumber(),
                        minutes
                );

                queue.addCall(request);

                Thread.sleep(random.nextInt(2000));
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
