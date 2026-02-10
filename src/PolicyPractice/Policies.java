package PolicyPractice;

import java.util.*;

public class Policies {
	Scanner sc=new Scanner(System.in);
	
	List<InsurancePolicy> policyList=new ArrayList<>();
	Map<Integer,InsurancePolicy> policyMap=new HashMap<>();
	
	//1
	
	public void addPolicy(){
		 try {
	            System.out.print("Enter Policy Number: ");
	            int policyNo = sc.nextInt();
	            sc.nextLine();
	            
	            if(policyMap.containsKey(policyNo)) {
	            	System.out.println("Duplicate Exists");
	            	return;
	            	}
	            else {
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
	                 
	                 InsurancePolicy ip1=new InsurancePolicy(policyNo,name,type,age,basePremium,status);
	                 policyMap.put(policyNo,ip1);
	                 policyList.add(ip1);
	            }
		 }catch(InvalidPolicyException e){
			 e.getMessage();
		 }
	}
	
	//2
	public void displayActivePolicies() {
		
		System.out.println("Enter Policy Number to display details:");
		int policyNo=sc.nextInt();
		if(policyMap.containsKey(policyNo)) {
			System.out.println(policyMap.get(policyNo));
		}
		else {
			System.out.println("Policy Number Does Not exists");
			return;
		}
	}
	//3
	public void findHighestPremiumPolicy() {
		
		InsurancePolicy max=null;
		for (InsurancePolicy i:policyList) {
			if(max==null||i.finalPremium>max.finalPremium) {
				max=i;
			}
		}System.out.println("The higest Premium is of :"+ max);
	}
	
	//4
	public void groupPoliciesByType() {
		
		Map<PolicyType,Integer> countMap=new HashMap<>();
		
		for(InsurancePolicy p: policyList) {
			countMap.put(p.policyType, countMap.getOrDefault(p.policyType, 0) + 1);
		}
		 for (Map.Entry<PolicyType, Integer> entry : countMap.entrySet()) {
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	}
	}
	//5
	public void removeExpiredPolicies() {
		Iterator<InsurancePolicy> it=policyList.iterator();
		
		while(it.hasNext()){
			InsurancePolicy p=it.next();
			if(p.status==PolicyStatus.EXPIRED) {
				it.remove();
				policyMap.remove(p.policyNumber);
			}
			
		}
		System.out.println("Expired Policy has been removed");
	}
}

