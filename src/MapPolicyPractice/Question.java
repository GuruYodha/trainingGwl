package MapPolicyPractice;
//An insurance company wants to build a Policy Management System to manage customer
//insurance details and calculate premiums.
//The system should:
//Store customer policy data using collections
//Perform different operations such as adding policies, 
//updating premiums, grouping policies, and generating reports
//Use both List and Map from the Java Collection Framework
//
//You are required to develop a console-based Java application
//that fulfills the following requirements.
//Required Operations (Must Use Collections)
//Implement the following functionalities:
//    Add a new policy
//    Prevent duplicate policy numbers
//    Update policy premium
//    Locate policy 
//    Recalculate premium
//    Display all active policies
//
//Use List to filter and display ACTIVE policies
//Group policies by policy type
//Display count of policies per policy type
//(Use Map<String, Integer>)
//
//Find highest premium policy
//Traverse the List to find the policy with maximum premium
//Remove expired policies
//Remove policies with status EXPIRED from the List
//Update the Map accordingly
//
//Exception Handling
//Create a custom exception InvalidPolicyTypeException
//Throw exception if policy type entered is invalid
//
//Insurance Policy Details
//Each insurance policy record must contain:
//    Policy Number (Integer)
//    Customer Name (String)
//    Policy Type (String: HEALTH, LIFE, VEHICLE, TRAVEL)
//    Customer Age (Integer)
//    Base Premium (Double)
//    Policy Status (String: ACTIVE, EXPIRED)
//    
//Premium Calculation Rules
//Policy Type Premium Increase
//Policy Type    Increase
//HEALTH    +20%
//LIFE    +35%
//VEHICLE    +15%
//TRAVEL    +10%
//
//Data Storage
//Store all insurance policies in a List<InsurancePolicy>
//Create a Map<Integer, InsurancePolicy> for fast lookup using Policy Number    
//
//Premium Calculation
//Calculate final premium using:
//Base Premium
//Policy Type increase
public class Question {

}
