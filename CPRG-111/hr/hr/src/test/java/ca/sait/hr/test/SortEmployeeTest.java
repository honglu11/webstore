/**
 * 
 */
package ca.sait.hr.test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFactory;
import ca.sait.hr.dao.ObjectNotFoundException;
import ca.sait.hr.model.Employee;
import ca.sait.hr.model.EmployeeFunctions;

/**
 * @author celias
 *
 */
public class SortEmployeeTest {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void sortEmployees() throws ObjectNotFoundException {
		
		final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
		final LocalDate now = LocalDate.now();
		employeeDAO.add("fred", "smith", now, 2.0);
		employeeDAO.add("Mike", "joHN", now, 2.0);
		employeeDAO.add("albert", "smith", now, 2.0);
		employeeDAO.add("luke", "duke", now, 2.0);

		final List<Employee> all = employeeDAO.findAll();
		
		// JDK 7 and Older
		Collections.sort(all);

		final List<UUID> oids = all.stream()
				.map(EmployeeFunctions.UUID_STYE)
				.collect(Collectors.toList());
			
		for (final UUID oid: oids) {
			System.out.println(oid);
		}
		
		final List<String> lastFirst = all.stream()
			.map(EmployeeFunctions.SHORT_STYE)
			.collect(Collectors.toList());
		
		for (final String name: lastFirst) {
			System.out.println(name);
		}
		
	}
}













