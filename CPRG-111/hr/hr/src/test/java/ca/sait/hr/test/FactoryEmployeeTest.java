/**
 * 
 */
package ca.sait.hr.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFactory;
import ca.sait.hr.dao.ObjectNotFoundException;
import ca.sait.hr.model.Employee;

/**
 * @author celias
 *
 */
public class FactoryEmployeeTest {
	
	@Test
	public void createInstance() throws ObjectNotFoundException {
		final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
		final LocalDate now = LocalDate.now();
		final Employee emp = employeeDAO.add("fred", "smith", now, 2.00);

		final EmployeeDAO employeeDAO2 = EmployeeDAOFactory.createInstance();
		final Optional<Employee> test = employeeDAO2.findBy(emp.getOid());
		
		assertTrue(test.isPresent(), "employee not created");
		
	}

	@Test
	public void notFindEmployee() throws ObjectNotFoundException {
		
		final ObjectNotFoundException exception = assertThrows(ObjectNotFoundException.class, () -> {
			final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
			employeeDAO.findBy(UUID.randomUUID());
		});
		
		assertNotNull(exception, "employee was found");
	}

	
	@Test
	public void sameEmployeeAllData() {
		final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
		final Employee emp = employeeDAO.add("fred", "smith", LocalDate.now(), 2.0);
		final Employee emp2 = employeeDAO.add("fred", "smith", LocalDate.now(), 2.0);

		boolean isSame = emp.equals(emp2);
		
		assertTrue(isSame, "The employee are not the same");
		
		System.out.println("Is the same: " + isSame);
	}

	@Test
	public void sameEmployeeAllDiffSalary() {
		final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
		final Employee emp = employeeDAO.add("fred", "smith", LocalDate.now(), 2.0);
		final Employee emp2 = employeeDAO.add("fred", "smith", LocalDate.now(), 3.0);

		boolean isSame = emp.equals(emp2);
		
		assertTrue(isSame, "The employee are not the same");
		
		System.out.println("Is the same: " + isSame);
	}

	@Test
	public void differentEmployee() {
		final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
		final Employee emp = employeeDAO.add("fred1", "smith", LocalDate.now(), 2.0);
		final Employee emp2 = employeeDAO.add("fred", "smith", LocalDate.now(), 2.0);

		boolean isSame = emp.equals(emp2);
		
		assertFalse(isSame, "The employee are the same");
		
		System.out.println("Is the same: " + isSame);
	}

	@Test
	public void findEmployee() throws ObjectNotFoundException {
		final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
		final Employee emp = employeeDAO.add("fred", "smith", LocalDate.now(), 2.0);
		final Optional<Employee> emp2 = employeeDAO.findBy(emp.getOid());
		
		System.out.println(emp2);
	}
}