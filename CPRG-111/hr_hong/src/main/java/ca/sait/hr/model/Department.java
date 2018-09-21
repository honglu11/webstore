/**
 * 
 */
package ca.sait.hr.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author honglu
 *
 */
public class Department extends DataItem {
	
	//immunable
	private final String name;
	private final Set<Employee> employees = new HashSet<>();
	
	public Department(String name) {
		this.name = name;
	}
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
		name = name;
	}
	/**
	 * @return the employees
	 */
	public Set<Employee> getEmployees() {
		return employees;
	}
//	/**
//	 * @param employees the employees to set
//	 */
//	public void setEmployees(Set<Employee> employees) {
//		this.employees = employees;
//	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Department other = (Department) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {		
		return getName().concat(" - OID - ").concat(this.getOid().toString());
	}
	
	private String getEmployeesName() {
	  return null;
	}

}
