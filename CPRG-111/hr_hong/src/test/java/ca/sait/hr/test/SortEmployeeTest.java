/**
 * 
 */
package ca.sait.hr.test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.Test;

import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFatory;
import ca.sait.hr.dao.ObjectNotFoundException;
import ca.sait.hr.model.Employee;
import ca.sait.hr.model.EmployeeFunctions;

/**
 * @author honglu
 *
 */
public class SortEmployeeTest {

	/**
	 * 
	 */
	@Test
	public void SortEmployee() throws ObjectNotFoundException {
		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();

		final LocalDate now = LocalDate.now();
		final Employee emp = employeeDAO.add("fred", "smith1", now, 2.00);
		final Employee emp2 = employeeDAO.add("mike1", "smith2", now, 2.00);
		final Employee emp3 = employeeDAO.add("mike2", "smith3", now, 2.00);
		final Employee emp4 = employeeDAO.add("mike3", "smith4", now, 2.00);
		
		final List<Employee> all = employeeDAO.findAll();
		
		Collections.sort(all);
		
		final List<UUID> oids = all.stream().map(EmployeeFunctions.UUID_STYE).collect(Collectors.toList());
		
		
		for ( final UUID oid : oids) {
			System.out.println(oid);
		}
		
		final List<String> lastFirst = all.stream().map(EmployeeFunctions.SHORT_STYE).collect(Collectors.toList());
		
		for ( final String lf: lastFirst) {
			System.out.println(lf);
		}
		

	}

}
