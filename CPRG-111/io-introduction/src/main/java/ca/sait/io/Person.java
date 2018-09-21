/**
 * 
 */
package ca.sait.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author honglu
 *
 */
public class Person implements Serializable {
	/**
	 *  
	 */
	private static final long serialVersionUID = 5029004755200151160L;

	/**
	 * Marker interface Serializable
	 */
	
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		//oos.defaultWriteObject(); // transient data cannot go to default write and read, but it can go to obviously write and read in the following code.
		oos.writeObject(name);
		oos.writeDouble(salary);
		oos.writeObject(birthdate);
		oos.writeObject(LocalDateTime.now());		
	}
	
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		//ois.defaultReadObject();
		name = (String) ois.readObject();
		salary = ois.readDouble();
		birthdate = (LocalDate)ois.readObject();
		final LocalDateTime date = (LocalDateTime)ois.readObject();
		System.out.println("Object was serialized: " + date.toString());
	}

	
	// no data method can implement
	// if change the field or change anything, better to regenerate the serialVersionUID
	
	private String name;
	private LocalDate birthdate;
	private transient Double salary; // if don't want to serialized use transient then cannot deserizliable
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}


	
}