package StreamPractice2;

public class Employee {
	private String name;
	private int age;
	private double Salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double d) {
		Salary = d;
	}
	public Employee(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", Salary=" + Salary + "]";
	}
	
	
}
//Create an Employee class with three fields: name, age and salary
//Create the constructor and getter setters for the fields
//Create collection of Employee objects in main method
//Using stream filter out all employees whose salary in greater than 5000
//Sort the employees by age
//Calculate bonus for each employee and display (Bonus= 10% of salary)