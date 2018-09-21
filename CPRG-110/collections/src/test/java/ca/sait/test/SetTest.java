/**
 * 
 */
package ca.sait.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ca.sait.model.Person;

/**
 * @author honglu
 *
 */
public class SetTest {

	@Test// when use set must implment equal in object.
	public void addPerson() {
		Person person1 = new Person(1, "Test", 15);
		Person person2 = new Person(1, "Test", 15);
		Person person3 = new Person(2, "Test", 15);
		
		Set<Person> people = new HashSet<>();
		System.out.println("Added Person1: " + people.add(person1));
		System.out.println("Added Person2: "  + people.add(person2)); // get false, since set is not allowed two objects with the same fields
		
		System.out.println(" Set size: " + people.size());
		
		System.out.println("Contains Person2 " + people.contains(person2)); // though person2 does not in people, person1 is equal to person2, so return true
		System.out.println("Contains Person3 " + people.contains(person3)); // person1 is not equal to person3, so return true
	}

}
