package CollectionDemo;

import java.util.*;

public class CompartorPractice {

	public static void main(String[] args) {
		
		//Set:-
		
		Set<Student> stud=new TreeSet<>(new CompareName());
		
		stud.add(new Student(1,"Rehman",5));
		stud.add(new Student(2,"Ali",6));
		stud.add(new Student(3,"Muzammil",7));
		stud.add(new Student(4,"Bismil",8));
		
		
		//List
		
		List<Student> std=new ArrayList<>();
		std.add(new Student(1,"Rehman",5));
		std.add(new Student(2,"Ali",6));
		std.add(new Student(3,"Muzammil",7));
		std.add(new Student(4,"Bismil",8));
		
		Collections.sort(std,new CompareName());
		
		
	System.out.println(stud);
	System.out.println(std);

	}

}
