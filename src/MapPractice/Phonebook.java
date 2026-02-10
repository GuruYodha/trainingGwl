package MapPractice;

import java.util.*;

public class Phonebook {
	
	public static void main(String[] args) {
		System.out.println("======== Welcome to GuruPhoneBookSystem =======");
		
		TreeMap<Long,Contact> contact=new TreeMap<>();
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
			contact.put(number,new Contact(name,number));
			System.out.println("add");
			break;
		
		case 2:
			
			System.out.println("provide the number you want to delete");
			long number1=sc.nextLong();
			
			if(contact.containsKey(number1)) {
				System.out.println("number deleted "+number1);
				contact.remove(number1);
				
			}
			else {
				System.out.println("not found");
			}
		
			break;
			
		case 3:
			System.out.println("provide the number you want to view");
			long number2=sc.nextLong();
			
			for(Map.Entry<Long, Contact> e:contact.entrySet()) {
				if(number2==e.getKey()) {
					System.out.println("Number Found "+number2+" The Person's Name is "+e.getValue());
				}
				else {
					System.out.println("Number Not found");
				}
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

		System.out.println("====== CONTACTS ======");
		
		for(Map.Entry<Long, Contact> e:contact.entrySet()) {
			System.out.println(e.getValue());
		}
		System.out.println("====== THANKS FOR USING GURU PHONEBOOK ======");
		
	}
	}
	

