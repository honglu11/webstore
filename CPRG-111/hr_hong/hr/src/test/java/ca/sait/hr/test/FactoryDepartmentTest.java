/**
 * 
 */
package ca.sait.hr.test;

import org.junit.jupiter.api.Test;

import ca.sait.hr.dao.DepartmentDAO;
import ca.sait.hr.dao.DepartmentDAOFactory;
import ca.sait.hr.model.Department;

/**
 * @author celias
 *
 */
public class FactoryDepartmentTest {

	@Test
	public void createInstance() {
		
		final DepartmentDAO departmentDAO = DepartmentDAOFactory.createInstance();
		final Department department = departmentDAO.add("IT");
		
		System.out.println(department);
	}
}