/**
 * 
 */
package ca.sait.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import ca.sait.model.Person;

/**
 * @author honglu
 *
 */
public class SortTest {

	@Test// when use set must implment equal in object.
	public void addPerson() {
		Person person1 = new Person(1, "Mike", 105);
		Person person2 = new Person(2, "Bill", 15); // if did not implment hash code Person person2 = new Person(1, "Test", 15); then turn out to be address person, then person1 and person2 duplicate won't detect, all object will print out, if has hash code, regard person1 and person2 are the same.
		Person person3 = new Person(3, "Anne", 5);
		Person person4 = new Person(4, "Test", 25);
		Person person5 = new Person(5, "Nick", 35);
		
		// cannot put primitive type in map <>, but can use object, hash code is important
        List<Person> people = new ArrayList<>(5); // linkedHashSet has link to object and print out the object in order, performance a little bit slow
        people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(person4);
		
		// sort is gernally a sort, set is generally aorder. set order, cannot sort, unorder collection is set.
		//Collections.sort(people);
		
		// a nonimate classes
		
		final Comparator<Person> sortAge = new Comparator<Person>()  {			

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return Long.compare(o1.getAge(), o2.getAge());
			}
		};
		// google mutiple sorting
		Collections.sort(people, sortAge.reversed());
		
		for (Person p : people) {
			System.out.println(" p " + p.toString());
		}
		
		// JDK 8
		Collections.sort(people, Comparator.comparing(Person::getName).reversed());
		
        System.out.println("run contains:  ");
 
		// set is not in order
		for (Person p1 : people) {
			System.out.println(" p " + p1.toString());
		}
		
		System.out.println(" Set size: " + people.size());
	
	}

}
