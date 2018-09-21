/**
 * 
 */
package ca.sait.hr.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Ignore;
import org.junit.Test;

import ca.sait.hr.dao.DepartmentDAO;
import ca.sait.hr.dao.DepartmentDAOFatory;
import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFatory;
import ca.sait.hr.dao.ObjectNotFoundException;
import ca.sait.hr.model.Department;
import ca.sait.hr.model.Employee;

/**
 * @author honglu
 *
 */
public class FactoryEmployeeTest {

//	public static void main(String[] args) {
		// if use interface need implment class has protected constructor
//		EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();
//
//		Employee emp = employeeDAO.add("fred", "smith", LocalDate.now(), 2.00);
		// Employee emp2 = employeeDAO.add("fred2", "smith2", LocalDate.now(), 3.00);
		// Employee emp = new Employee();
		// emp.setBirthDate(LocalDate.now());
		// emp.setFirstName("fred");
		// emp.setLastName("smith");
		// emp.setSalary(2.00);
		//
		// employeeDAO.add(emp);

//		System.out.println(emp);

		// DepartmentDAO departmentDAO = DepartmentDAOFatory.createInstance();

		// Set<Employee> emps = new HashSet<>();
		// emps.add(emp1);
		// emps.add(emp2);
		//
		//
		// Department dep = new Department("IT");
		//
		// dep.setEmployees(emps);
		//
		// System.out.println(dep);

//	}
	@Test
	public void testDate() {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE; 
		LocalDate date = LocalDate.parse("20150927", formatter); 
		System.out.println("date string : 20150927, " + "localdate : " + date);

//		String str = "2012-12-12";
//		LocalDate date = LocalDate.parse(str);
//		System.out.println(date.toString());
	}

	@Test
	public void createInstance() throws Exception {

		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();

		final LocalDate now = LocalDate.now();
		final Employee emp = employeeDAO.add("fred", "smith", now, 2.00);
		final Employee emp2 = employeeDAO.add("mike", "smith", now, 2.00);
		final Employee emp3 = employeeDAO.add("mike", "smith", now, 2.00);
		final Employee emp4 = employeeDAO.add("mike", "smith", now, 2.00);
		
		// since database is sigleton, then the seconde EmplyeeDAO can create the instatnce and add the employee in the same inMemoryDatabase();
		final EmployeeDAO employeeDAO2 = EmployeeDAOFatory.createInstance();
		//final Employee emp3 = employeeDAO2.add("mike", "smith", LocalDate.now(), 2.00);
		
		final Optional<Employee> test = employeeDAO.findBy(emp.getOid());
		assertNotNull("employee not created", test.isPresent());
		//employeeDAO.findAll().stream().forEach(System.out::println);
		employeeDAO2.findAll().stream().forEach(System.out::println);
		//System.out.println(emp);
		
	}
	
	@Test(expected=ObjectNotFoundException.class)
	public void notFindEmployee() throws ObjectNotFoundException{

		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();
		
		final Optional<Employee> test = employeeDAO.findBy(UUID.randomUUID()); // after add exception, the code will be end here, the following code never executed.
		//final Employee emp = test.get();
		//final Employee emp = test.orElse(null); // optional feature
//		final Employee emp = test.orElse(new Employee());
		//final Employee emp = test.orElse(null);
//		if test.isPresent() 
//		  emp = test.get();
//		else
//			emp = null
		final Optional<Employee> emp = test.filter(e->e.getBirthDate().isBefore(LocalDate.now())) ;
		//final String name = emp.map(Employee::toString).orElse("No Employee");
		final String name = emp.map(e->e.getOid().toString()).orElse("No Employee"); // orElse(null)
		//Optional<List<Optional>> a = Optional.of(new ArrayList());
		
		System.out.println(emp);
		assertNull("employee was created", emp);		
	}
	
	@Test	
	public void sameEmployee() {
		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();

		final Employee emp = employeeDAO.add("mike", "smith", LocalDate.now(), 2.00);
		final Employee emp2 = employeeDAO.add("mike", "smith", LocalDate.now(), 2.00);
		
		boolean isSame = emp.equals(emp2);
		// when use a static import, can use this method as a method add into test class, static linking, when compile the code this method become the part of the code
		
		
//		Double a = null;
//		double b = a;
		
		assertTrue("The employee are not the same", isSame);
		
		System.out.println("Is the same " + isSame);	
		
	}
	
	@Test	
	public void differentEmployee() {
		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();

		final Employee emp = employeeDAO.add("mike1", "smith", LocalDate.now(), 2.00);
		final Employee emp2 = employeeDAO.add("mike", "smith", LocalDate.now(), 2.00);
		
		boolean isSame = emp.equals(emp2);

		
		assertFalse("The employee are the same", isSame);
		
		System.out.println("Is the same " + isSame);	
		
	}
	
	
	@Test	
	public void sameEmployeeAllData() {
		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();

		final Employee emp = employeeDAO.add("mike", "smith", LocalDate.now(), 2.00);
		final Employee emp2 = employeeDAO.add("mike", "smith", LocalDate.now(), 2.00);
		
		boolean isSame = emp.equals(emp2);
		
		assertTrue("The employee are not the same", isSame);
		
		System.out.println("Is the same " + isSame);			
	}
	
	@Test	
	public void sameEmployeeAllDiffSalary() {
		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();

		final Employee emp = employeeDAO.add("mike", "smith", LocalDate.now(), 2.00);
		final Employee emp2 = employeeDAO.add("mike", "smith", LocalDate.now(), 3.00);
		
		boolean isSame = emp.equals(emp2);
		
		assertTrue("The employee are not the same", isSame);
		
		System.out.println("Is the same " + isSame);			
	}
	
	
	@Test
	public void findEmployee() throws ObjectNotFoundException {
		
		final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();

		final Employee emp = employeeDAO.add("mike", "smith", LocalDate.now(), 2.00); // use replace won't get emp.getOid, so use remove then put then getOid works.
		
		System.out.println("Employee: " + emp.toString());
		final Employee emp2 = employeeDAO.findBy(emp.getOid()).get(); // emp2 and emp has the same memory address
		
		
		emp2.setLastName("Bill"); // since change the name then emp2 is different then it get different address compare to original emp2. if final Emplyee e1 = e2, then e1 and e2 has the same adddrress because same object.
		
		System.out.println("Employee: " + emp2.toString());
		
	}
	
	@Test
	public void specialChar() {
		 Pattern pattern = Pattern.compile("[a-zA-Z0-9.]*");
		 
	      String str = "abc,";
	      Matcher matcher = pattern.matcher(str);
	 
	      if (!matcher.matches()) {
	           System.out.println("string '"+str + "' contains special character");
	      } else {
	           System.out.println("string '"+str + "' doesn't contains special character");
	      }
	}

}
