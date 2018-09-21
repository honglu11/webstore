/**
 * 
 */
package ca.sait.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

/**
 * @author honglu
 *
 */
public class WriteReadObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (final OutputStream ois = new FileOutputStream("./person.ser");  final ObjectOutputStream out = new ObjectOutputStream(ois)) {
			
			final Person person = new Person();
			person.setBirthdate(LocalDate.now());
			person.setName("Fred");
			person.setSalary(12.00);
	
			out.writeObject(person);
		} catch ( final Exception ex) {
			ex.printStackTrace();
		}

	}

}
