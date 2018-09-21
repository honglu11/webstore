/**
 * 
 */
package ca.sait.hr.dao;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ca.sait.hr.database.InMemoryDatabase;
import ca.sait.hr.model.DataItem;
import ca.sait.hr.model.Department;
import ca.sait.hr.model.Employee;

/**
 * @author honglu
 *
 */
public class EmployeeDAOMemoryImpl extends DataAccessObjectAbstract<Employee> implements EmployeeDAO {

	// create singleton instance since only one database for employee and
	// department.
	// private InMemoryDatabase database = InMemoryDatabase.createInstance();

	// private InMemoryDatabase database = new InMemoryDatabase();

	// make this one protected, then can create whatever you want.
	protected EmployeeDAOMemoryImpl() {
		super(Employee.class);
	}

	// /* (non-Javadoc)
	// * @see ca.sait.hr.dao.EmployeeDAO#add(ca.sait.hr.model.Employee)
	// */
	// @Override
	// public void add(Employee employee) {
	// database.update(employee);
	//
	// }

	@Override
	public Employee add(String firstName, String LastName, LocalDate birthDate, Double salary) {
		final Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(LastName);
		employee.setBirthDate(birthDate);
		employee.setSalary(salary);

		add(employee);

		return employee;
	}

	@Override
	public List<Employee> findAll() {
		final Comparator<Employee> sortType = Comparator.comparing(Employee::getLastName)
				.thenComparing(Employee::getFirstName).thenComparing(Employee::getBirthDate)
				.thenComparing(Employee::getSalary);

		return super.findAll().stream().sorted(sortType).collect(Collectors.toList());
	}

	// /* (non-Javadoc)
	// * @see ca.sait.hr.dao.EmployeeDAO#update(ca.sait.hr.model.Employee)
	// */
	// @Override
	// public void update(Employee employee) {
	// database.update(employee);
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see ca.sait.hr.dao.EmployeeDAO#delete(ca.sait.hr.model.Employee)
	// */
	// @Override
	// public void delete(Employee employee) {
	// database.remove(employee.getOid());
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see ca.sait.hr.dao.EmployeeDAO#findBy(java.util.UUID)
	// */
	// @Override
	// public Employee findBy(UUID oid) {
	// // TODO Auto-generated method stub
	// return (Employee)database.find(oid);
	// }
	//
	// /* (non-Javadoc)
	// * @see ca.sait.hr.dao.EmployeeDAO#findAll()
	// */
	// @Override
	// public List<Employee> findAll() {
	// // TODO Auto-generated method stub
	// return
	// database.findAll().stream().filter(Employee.class::isInstance).map(Employee.class::cast).collect(Collectors.toList());
	// }

	// if super remove is fine, since no the method in current class if one method
	// public List<Employee> findALL(Class<T> type) { return null, if no super
	// return null.
	// @Override
	// public List<Employee> findAll() {
	// return super.findAll(Employee.class);
	//
	// }
}
