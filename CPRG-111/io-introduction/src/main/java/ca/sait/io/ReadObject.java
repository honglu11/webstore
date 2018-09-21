/**
 * 
 */
package ca.sait.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

/**
 * @author honglu
 *
 */
public class ReadObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// if don't understand the seriliaze Id ( must use in deserilize, as long as class name is the same. 
		try (final InputStream ois = new FileInputStream("./person.ser");  final ObjectInputStream in = new ObjectInputStream(ois)) {
			
			final Person person = (Person) in.readObject();
			System.out.println("Bithday: " + person.getBirthdate());
			System.out.println("Name: " + person.getName());
			System.out.println("Salary: " + person.getSalary());

		} catch ( final Exception ex) {
			ex.printStackTrace();
		}

	}

}
