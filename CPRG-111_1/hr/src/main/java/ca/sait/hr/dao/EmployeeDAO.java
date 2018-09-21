/**
 * 
 */
package ca.sait.hr.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import ca.sait.hr.model.DataItem;
import ca.sait.hr.model.Employee;

/**
 * @author honglu
 *
 */
public interface EmployeeDAO extends DataAccessObject<Employee> {	

	Employee add(String firstName, String LastName, LocalDate birthDate, Double salary);

}
