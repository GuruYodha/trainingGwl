package MultiThreadingToughQuestion;

public class TelecomSystem {

    private static double totalRevenue = 0;

    public static synchronized void addRevenue(double amount) {
        totalRevenue += amount;
    }

    public static synchronized double getTotalRevenue() {
        return totalRevenue;
    }
}
