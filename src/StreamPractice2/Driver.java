package StreamPractice2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		
		List<Employee> el=Arrays.asList(new Employee("Rakhal",40,1000),
				new Employee("Rakhal",40,20000),
				new Employee("Abhay",47,50000),
				new Employee("Sanju",42,5000));
		
		el.stream()
	    .filter(e -> e.getSalary() > 5000)
	    .sorted(Comparator.comparing(Employee::getAge))
	    .map(e -> {
	        e.setSalary(e.getSalary() * 1.10); 
	        return e;
	    })
	    .forEach(System.out::println);

	}

}
