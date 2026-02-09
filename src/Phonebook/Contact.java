package Phonebook;

public class Contact implements Comparable<Contact>{
	
	public Contact(String name, long phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + "]" +"\n";
	}
	
	String name;
	long phoneNumber;
	
	public int compareTo(Contact o) {
		return Long.compare(this.phoneNumber,o.phoneNumber);
	}

}
