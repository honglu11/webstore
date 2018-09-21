/**
 * 
 */
package ca.sait.test;

import java.util.Collection;
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
public class MapTest {

	@Test// when use set must implment equal in object.
	public void addPerson() {
		Person person1 = new Person(1, "Test", 15);
		Person person2 = new Person(2, "Test", 15); // if did not implment hash code Person person2 = new Person(1, "Test", 15); then turn out to be address person, then person1 and person2 duplicate won't detect, all object will print out, if has hash code, regard person1 and person2 are the same.
		Person person3 = new Person(3, "Test", 15);
		Person person4 = new Person(4, "Test", 15);
		Person person5 = new Person(5, "Test", 15);
		
		// cannot put primitive type in map <>, but can use object, hash code is important
        Map<Integer, Person> people = new HashMap<>(); // linkedHashSet has link to object and print out the object in order, performance a little bit slow
        //Map<Person, List<Person>> people = new HashMap<>();
        // when go to cucurrency, either map or list, quick
		
        // key has to been unqiue
		final Person added1 = people.put(person1.hashCode(), person1);
		System.out.println("key 1 " + people.get(person1.hashCode()));
		final Person added2 = people.put(person2.hashCode(), person2);
		final Person added3 = people.put(person3.hashCode(), person3);
		final Person added4 = people.put(person4.hashCode(), person4);
		
        System.out.println("run contains:  ");
        
//        final Person added1 = people.put(person1.hashCode(), person1);
//		System.out.println("key 1 " + people.get(person1.hashCode()));
//		final Person added2 = people.put(person1.hashCode(), person2);  // get person1, the key of person 1 at this moment point to person1.
//		final Person added3 = people.put(person1.hashCode(), person3);  // get person2
//		final Person added4 = people.put(person1.hashCode(), person4); // get person3
		
		final boolean contains = people.containsKey(person3); // contains - set is fast
		
		System.out.println("Added person1:  " + added1);
		System.out.println("Added person2:  " + added2);
		System.out.println("Added person3:  " + added3);
		System.out.println("Added person4:  " + added4);
		System.out.println("Contains person3:  " + contains);
		
		System.out.println("set size " + people.size());
		
		// set is not in order
		for (Person p : people.values() ) {
			System.out.println(" p " + p.toString());
		}
		
		System.out.println(" Set size: " + people.size());
	
	}

}
