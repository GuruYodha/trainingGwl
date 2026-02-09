package CollectionDemo;

import java.util.Comparator;

public class CompareId implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			
			return o1.StudId-o2.StudId;
			
		}
		
		

	}

