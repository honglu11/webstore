/**
 * 
 */
package ca.sait.hr.dao;

import java.time.LocalDate;

import ca.sait.hr.model.Employee;

/**
 * @author celias
 *
 */
public interface EmployeeDAO
extends DataAccessObject<Employee> {

	Employee add(String firstName, String lastName, LocalDate birthdate, Double salary);
}














