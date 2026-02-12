package ThreadPractice2;

public class SharedResource {

	String data;
	boolean flag ;
	
	public void producer(String data,boolean flag) {
		this.data = data;
		this.flag = flag;
		
	}
	public void consumer() {
		if(flag) {
			System.out.println("Data is available: "+data);
		}
		else {
			System.out.println("Data is not available");
		}
	}
}
//Create a class called SharedResource having a field as data
//and a flag.
//create a method called producer which takes some value from the user
//and sets the data field.
//Before setting the field check your flag.
//create one more method called consumer which checks the flag and if
//data is available then display the data.
//Create another class having main method which creates producer and consumer as threads