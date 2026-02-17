package StreamPractice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee { 
   private int empId;
   private String empName;
   private int salary;
   private int age;
   private String department;
    public Employee(int empId, String empName, int salary, int age,String department) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.age = age;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", age=" + age
				+ ", department=" + department + "]";
	}
}

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Alice", 50000, 20, "HR"));
        employees.add(new Employee(2, "Bob", 60000, 30, "IT"));
        employees.add(new Employee(3, "Charlie", 55000, 25, "Finance"));
        employees.add(new Employee(4, "Bob", 70000, 28,"IT"));

        
//        Map<String, Long> result = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.counting()
//                ));
        
        // average salary by department
//        Map<String, Double> result = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.averagingInt(Employee::getSalary)
//                ));

        //2nd highest salary
//        Employee secondHighestSalaryEmployee = employees.stream()
//				.sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
//				.skip(1)
//				.findFirst()
//				.orElse(null);
        
        //oldest employee
        
//        Employee oldestEmployee = employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
//				.orElse(null);
        
   
        
        // employees with salary above average
        
        double averageSalary = employees.stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);

        List<Employee> aboveAverage = employees.stream()
                .filter(e -> e.getSalary() > averageSalary)
                .collect(Collectors.toList());

        aboveAverage.forEach(System.out::println);
    }
}
