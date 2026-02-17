package MultiThreadingToughQuestion;

public class Customer {

    private int customerId;
    private String name;
    private String phoneNumber;
    private double walletBalance;

    private static final double CALL_RATE = 2.0;

    public Customer(int customerId, String name, String phoneNumber, double walletBalance) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.walletBalance = walletBalance;
    }

    public synchronized void makeCall(int minutes) throws InsufficientBalanceException {

        double cost = minutes * CALL_RATE;

        if (walletBalance < cost) {
            throw new InsufficientBalanceException(
                    "Insufficient balance for " + name +
                            " | Required: ₹" + cost +
                            " | Available: ₹" + walletBalance);
        }

        walletBalance -= cost;
        TelecomSystem.addRevenue(cost);

        System.out.println(name + " made call for " + minutes +
                " mins | Deducted ₹" + cost +
                " | Remaining ₹" + walletBalance);
    }

    public synchronized void recharge(double amount) {
        walletBalance += amount;
        System.out.println(name + " recharged ₹" + amount +
                " | New Balance ₹" + walletBalance);
    }

    public synchronized double getBalance() {
        return walletBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
