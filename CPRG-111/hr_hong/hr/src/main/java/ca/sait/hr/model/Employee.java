/**
 * 
 */
package ca.sait.hr.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

/**
 * @author celias
 *
 */
public class Employee extends DataItem
implements Comparable<Employee> {

	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private Double salary;

	@Override
	public int compareTo(Employee other) {
		
		final int compareLastName = this.lastName.compareToIgnoreCase(other.lastName);
		if (compareLastName == 0) {
			return this.firstName.compareToIgnoreCase(other.firstName);
		}
					
		return compareLastName;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName != null && firstName.trim().length() > 0)
			this.firstName = firstName.trim().toUpperCase();
		else
			this.firstName = null;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName != null && lastName.trim().length() > 0)
			this.lastName = lastName.trim().toUpperCase();
		else
			this.lastName = null;
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
	
	public String toString() {
		
		final String ln = getLastName() != null ? getLastName() : "";
		final String fn = getFirstName() != null ? getFirstName() : "";

		final String formattedSalary;
		if (salary != null) {
			final DecimalFormat decimalFormat = new DecimalFormat("$#,###.00 CAN");
			formattedSalary = decimalFormat.format(salary);
		} else {
			formattedSalary = "";
		}
		
		final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		final String formattedDate = birthdate.format(dateFormatter);
		
		final StringBuilder str = new StringBuilder();
		
		str.append("OID: ").append(getOid().toString()).append("\n");
		str.append("Last Name: ").append(ln).append("\n");
		str.append("First Name: ").append(fn).append("\n");
		
		str.append("Salary: ").append(formattedSalary).append("\n");
		str.append("Birthdate: ").append(formattedDate).append("\n");
		
		return str.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	public String customPrint(Function<Employee,String> function) {
		return function.apply(this);
	}
	
}























