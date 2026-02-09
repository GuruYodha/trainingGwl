package CollectionDemo;

import java.util.Comparator;

public class Student{
	
	int StudId;
	String StudName;
	int Class1;
	
	
	public Student(int studId, String studName, int class1) {
		super();
		StudId = studId;
		StudName = studName;
		Class1 = class1;
	}


	@Override
	public String toString() {
		return "Student [StudId=" + StudId + ", StudName=" + StudName + ", Class1=" + Class1 + "]"+"\n";
	}

	
}



