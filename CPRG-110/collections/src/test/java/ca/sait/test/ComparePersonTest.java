/**
 * 
 */
package ca.sait.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.sait.model.Person;

/**
 * @author honglu
 *
 */
public class ComparePersonTest {

	@Test
	public void isTheSame() {
		Person person1 = new Person(1, "Test", 15);
		Person person2 = new Person(2, "Test", 15);
		Person person3 = new Person(3, "Test", 15);
		Person person4 = new Person(4, "Test", 15);
		
		// HashSet is faster than linkList, 
		//
		//HashSet<Person> people = new HashSet<>();
		//list go through entire list to see object exist, set call contain, it know it exist or not, do't need to go through whole thing
		//Collection<Person> people = new ArrayList<>();
		
		//Collection<Person> people = new HashSet<>();
		//List<Person> people = new ArrayList<>();
		//Set<Person> people = new HashSet<>();
		Collection<Person> people = new LinkedHashSet<>(); // linkedHashSet has link to object and print out the object in order, performance a little bit slow
		
		final boolean added1 = people.add(person1);
		final boolean added2 = people.add(person2);
		final boolean added3 = people.add(person3);
		final boolean added4 = people.add(person4);
		
		System.out.println("run contains:  ");
		
		final boolean contains = people.contains(person3); // contains - set is fast
		
		// list can add duplicate object
		
		System.out.println("Added person1:  " + added1);
		System.out.println("Added person2:  " + added2);
		System.out.println("Added person3:  " + added3);
		System.out.println("Added person4:  " + added4);
		System.out.println("Contains person3:  " + contains);
		
		System.out.println("set size " + people.size());
		
		// set is not in order
		for (Person p : people ) {
			System.out.println(" p " + p);
		}
		//final Person p = people.get(1); list 
		// when two persons object has the same value of attributes/field, hashcode will be the same.
//		System.out.println(person1.hashCode());
//		System.out.println(person2.hashCode());
//		System.out.println(person3.hashCode());
//
//		if (person1.getClass() == person2.getClass()) {
//			System.out.println("The same");
//		} else {
//			System.out.println("NOT THE SAME!!");
//		}
//
//		// compare address
//		if (person1 == person2) {
//			System.out.println("The same");
//		} else {
//			System.out.println("NOT THE SAME!!");
//		}
//
//		// compare address
//		if (person1.equals(person2)) {
//			System.out.println("The same");
//		} else {
//			System.out.println("NOT THE SAME!!");
//		}
//
//		// compare address
//		if (person1.equals(person1)) {
//			System.out.println("The same");
//		} else {
//			System.out.println("NOT THE SAME!!");
//		}

	}
}
