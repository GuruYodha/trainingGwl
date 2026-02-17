package MultiThreadingToughQuestion;

public class CallRequest {

    private int requestId;
    private String phoneNumber;
    private int minutes;

    public CallRequest(int requestId, String phoneNumber, int minutes) {
        this.requestId = requestId;
        this.phoneNumber = phoneNumber;
        this.minutes = minutes;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMinutes() {
        return minutes;
    }
}
