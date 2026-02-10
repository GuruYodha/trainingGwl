package MapPolicyPractice;

import java.util.*;

public class PolicyManagementSystem {

    static List<InsurancePolicy> policyList = new ArrayList<>();
    
    static Map<Integer, InsurancePolicy> policyMap = new HashMap<>();
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n---- Welcome to Guru Policy Management System ----");
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
                    addPolicyUserInput();
                    break;
                case 2:
                    displayActivePolicies();
                    break;
                case 3:
                    findHighestPremiumPolicy();
                    break;
                case 4:
                    groupPoliciesByType();
                    break;
                case 5:
                    removeExpiredPolicies();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }

    static void addPolicyUserInput() {
        try {
            System.out.print("Enter Policy Number: ");
            int policyNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Policy Type (HEALTH/LIFE/VEHICLE/TRAVEL): ");
            String type = sc.nextLine();

            System.out.print("Enter Customer Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Base Premium: ");
            double basePremium = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Policy Status (ACTIVE/EXPIRED): ");
            String status = sc.nextLine();

            InsurancePolicy policy = new InsurancePolicy(policyNo, name, type, age, basePremium, status);
            addPolicy(policy);

        } catch (InvalidPolicyTypeException e) {
            System.out.println(e.getMessage());
        }
    }

 
    static void addPolicy(InsurancePolicy policy) {
        if (policyMap.containsKey(policy.policyNumber)) {
            System.out.println("Duplicate policy number not allowed: " + policy.policyNumber);
            return;
        }
        policyList.add(policy);
        policyMap.put(policy.policyNumber, policy);
        System.out.println("Policy added successfully!");
    }

    
    static void displayActivePolicies() {
        System.out.println("\nActive Policies:");
        for (InsurancePolicy p : policyList) {
            if (p.status == PolicyStatus.ACTIVE) {
                System.out.println(p);
            }
        }
    }

    
    static void findHighestPremiumPolicy() {
        InsurancePolicy maxPolicy = null;

        for (InsurancePolicy p : policyList) {
            if (maxPolicy == null || p.finalPremium > maxPolicy.finalPremium) {
                maxPolicy = p;
            }
        }

        System.out.println("\nHighest Premium Policy:");
        System.out.println(maxPolicy);
    }

    
    static void groupPoliciesByType() {
        Map<PolicyType, Integer> countMap = new HashMap<>();

        for (InsurancePolicy p : policyList) {
            countMap.put(p.policyType, countMap.getOrDefault(p.policyType, 0) + 1);
        }

        System.out.println("\nPolicy Count by Type:");
        for (Map.Entry<PolicyType, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    
    static void removeExpiredPolicies() {
        Iterator<InsurancePolicy> iterator = policyList.iterator();

        while (iterator.hasNext()) {
            InsurancePolicy p = iterator.next();
            if (p.status == PolicyStatus.EXPIRED) {
                iterator.remove();
                policyMap.remove(p.policyNumber);
            }
        }

        System.out.println("\nExpired policies removed.");
    }
}
