package StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2{

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(new Employee(101,"Sourav",20000),
				new Employee(102,"Manish",10000),
				new Employee(103,"Ramesh",20000),
				new Employee(104,"Shelly",20000));

				empList.stream().filter(emp->emp.getEmpname().startsWith("S")).
				sorted(Comparator.comparing(Employee :: getSalary).thenComparing(Employee :: getEmpId).reversed())
				.forEach(System.out :: println);
        
    }

}
