package LambdaPractice2;
import java.util.function.Function;
import java.util.Scanner;

public class Main1{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name, Salary and Id");
		String name=sc.nextLine();
		int salary=sc.nextInt();
		int id=sc.nextInt();
		
		
		Employee emp=new Employee(id,name,salary);
		System.out.println("The Salary before is "+emp);
		
		//Increase Salary by 10%
		
		Function<Integer,Integer> increaseSal= a->a+(a*10/100);
		int result=increaseSal.apply(salary);
		
		emp.setRevisedSalary(result);
		System.out.println("The salary after revision is " +emp);
		
		
	}
}