package CollectionDemo;

import java.util.*;

public class CompareClass implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			
			return o1.Class1-o2.Class1;
			
		}
		
		

	}
