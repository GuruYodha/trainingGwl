package MapPractice;

public class Contact{
	
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
	
}

