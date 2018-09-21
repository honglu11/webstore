/**
 * 
 */
package ca.sait.hr.dao;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ca.sait.hr.model.Employee;

/**
 * @author celias
 *
 */
public class EmployeeDAOMemoryImpl extends DataAccessObjectAbstract<Employee>
implements EmployeeDAO {

	protected EmployeeDAOMemoryImpl() {
		super(Employee.class);
	}

	@Override
	public Employee add(String firstName, String lastName, LocalDate birthdate, Double salary) {
		final Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		employee.setBirthdate(birthdate);
		
		add(employee);
		
		return employee;
	}
	
	@Override
	public List<Employee> findAll() {
		
		final Comparator<Employee> sortType =
				Comparator.comparing(Employee::getLastName)
					.thenComparing(Employee::getFirstName)
					.thenComparing(Employee::getBirthdate)
					.thenComparing(Employee::getSalary);
		
		return super.findAll().stream()
					.sorted(sortType)
					.collect(Collectors.toList());
	}
	
}



















