package PolicyPractice;

import java.util.Scanner;

public class PolicyManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Policies policies = new Policies();

        while (true) {
            System.out.println("\n---- Guru Policy Management System ----");
            System.out.println("1. Add Policy");
            System.out.println("2. Display Active Policies");
            System.out.println("3. Find Highest Premium Policy");
            System.out.println("4. Group Policies by Type");
            System.out.println("5. Remove Expired Policies");
            System.out.println("6. Exit");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    policies.addPolicy();
                    break;
                case 2:
                    policies.displayActivePolicies();
                    break;
                case 3:
                    policies.findHighestPremiumPolicy();
                    break;
                case 4:
                    policies.groupPoliciesByType();
                    break;
                case 5:
                    policies.removeExpiredPolicies();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.out.println("----Thanks for visiting us----");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
