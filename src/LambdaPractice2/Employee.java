package LambdaPractice2;

import java.util.function.Function;

public class Employee {
	int empId;
	String empName;
	int empSalary;
	
	public Employee(int empId, String empName, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

	
	public void setRevisedSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
}

