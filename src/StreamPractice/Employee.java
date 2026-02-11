package StreamPractice;

public class Employee {
	private String Empname;
	private int EmpId;
	private int Salary;
	
	
	
	
	public String getEmpname() {
		return Empname;
	}

	public void setEmpname(String empname) {
		Empname = empname;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [Empname=" + Empname + ", EmpId=" + EmpId + ", Salary=" + Salary + "]";
	}

	public Employee( int empId,String empname, int salary) {
		super();
		Empname = empname;
		EmpId = empId;
		Salary = salary;
	}


}
