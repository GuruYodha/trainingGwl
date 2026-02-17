package MultiThreadingToughQuestion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consumer implements Runnable {

    private CallQueue queue;
    private Map<String, Customer> customerMap;

    public Consumer(CallQueue queue, List<Customer> customers) {

        this.queue = queue;
        customerMap = new HashMap<>();

        for (Customer c : customers) {
            customerMap.put(c.getPhoneNumber(), c);
        }
    }

    @Override
    public void run() {

        while (true) {

            CallRequest request = queue.processCall();

            if (request != null) {

                Customer customer =
                        customerMap.get(request.getPhoneNumber());

                try {

                    customer.makeCall(request.getMinutes());
                    logCall(request);

                } catch (InsufficientBalanceException e) {

                    System.out.println("Call Failed: " + e.getMessage());
                }
            }
        }
    }

    private void logCall(CallRequest request) {

        System.out.println("Call Logged | ID: " +
                request.getRequestId() +
                " | Phone: " +
                request.getPhoneNumber() +
                " | Minutes: " +
                request.getMinutes());
    }
}
