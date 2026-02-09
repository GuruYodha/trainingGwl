package Phonebook;
import java.util.*;
public class CompareName implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		
		return o1.name.compareTo(o2.name);
	}

}
