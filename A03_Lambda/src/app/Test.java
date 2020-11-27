package app;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/**
 * 
 * @author micha
 * Aufgabe: Es gibt in Java ein Iterface Comparator<T>
 * Der TrimComparator soll verwendet werden können, um Listen mit Leerzeichen
 * sortieren zu können
 *
 */

class TrimComperator implements Comparator<String>{
	
	@Override
	public int compare(String o1, String o2) {
		// Negative Zahl -> kleinerer Wert, positve Zahl -> der größere Wert
		return o1.trim().compareTo(o2.trim()); // 
	}
	
}

public class Test {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add(" Otto");
		list.add(" Ina");
		list.add("  Anna");
		list.add("Elke");
		list.add("Änton");
		System.out.println(list);
		//	Collections.sort(list ,new TrimComperator());
		
		// Diesmal als Lambda-Ausdruck
		Collections.sort(list ,  (s1,s2)->   s1.trim().compareTo(s2.trim())   );
		
	//	Collections.sort(list ,  Collator.getInstance(Locale.GERMAN));
		System.out.println(list);// Alphabetische Reihenfolge
		
		
		//
	}

}
