/**
 * 
 */
package ca.sait.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author honglu
 *
 */
public class PersonExtern implements Externalizable {
	/**
	 * not required serialVersionUID
	 */
	private static final long serialVersionUID = 5029004755200151160L;

	/**
	 * Marker interface Serializable
	 */
	
	
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


	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		salary = in.readDouble();
		birthdate = (LocalDate)in.readObject();
		final LocalDateTime date = (LocalDateTime)in.readObject();
		System.out.println("Object was serialized: " + date.toString());
		
	}


	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeDouble(salary);
		out.writeObject(birthdate);
		out.writeObject(LocalDateTime.now());	
		
	}


	
}
