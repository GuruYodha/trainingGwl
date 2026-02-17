package MultiThreadingToughQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class CallQueue {

    private Queue<CallRequest> queue = new LinkedList<>();
    private final int MAX_SIZE = 5;

    public synchronized void addCall(CallRequest request) {

        try {
            while (queue.size() == MAX_SIZE) {
                wait();
            }

            queue.add(request);
            System.out.println("Added Call Request: " + request.getRequestId());

            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized CallRequest processCall() {

        try {
            while (queue.isEmpty()) {
                wait();
            }

            CallRequest request = queue.poll();
            notifyAll();
            return request;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
