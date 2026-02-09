package Phonebook;

import java.util.*;

public class Phonebook {
	
	public static void main(String[] args) {
		System.out.println("======== Welcome to GuruPhoneBookSystem =======");
		
		Set<Contact> contact = new TreeSet<>();
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("Press 1 to Add a Number to Contacts\n"+
				"Press 2 to Delete a Number from Contacts\n"+
				"Press 3 to View a Number from Contacts\n"+
				"Press 4 to Exit");
		
		int input=sc.nextInt();
		switch(input) {	
		case 1:
			System.out.println("enter contact");
			long number=sc.nextLong();
			System.out.println("enter name");
			sc.nextLine();
			String name=sc.nextLine();
			contact.add(new Contact(name,number));
			System.out.println("add");
			break;
		
		case 2:
			
			System.out.println("provide the number you want to delete");
			long number1=sc.nextLong();
			Iterator<Contact> i=contact.iterator();
			boolean removed=false;
			
			while(i.hasNext()) {
				Contact c=i.next();
				
				if(number1==c.phoneNumber) {
					i.remove();
					System.out.println("Number removed from Contacts is"+ number1);
				}
				else {
					System.out.println("Number not found");
				}
			}
			
			break;
			
		case 3:
			System.out.println("provide the number you want to view");
			long number2=sc.nextLong();
			for(Contact c:contact) {
				if (number2==c.phoneNumber)System.out.println("The Name is "+ c.name +"\n"
						+ "The Contact Number is "+ c.phoneNumber);
				
				else System.out.println("Contact not Availabe");
			}
			break;
		case 4:
			System.out.println("====== THANKS FOR USING GURU PHONEBOOK ======");
			System.exit(1);
			break;
		}
			System.out.println("Do u want to use again....Y/N");
			System.out.println("just confirm ");
			sc.nextLine();
			String cont=sc.nextLine();
			if(!cont.equalsIgnoreCase("Y"))break;
		}
//		
//		Collections.sort(contact, new CompareName());
		System.out.println("====== CONTACTS ======");
		System.out.println(contact);
		System.out.println("====== THANKS FOR USING GURU PHONEBOOK ======");
		
	}
	}
	

