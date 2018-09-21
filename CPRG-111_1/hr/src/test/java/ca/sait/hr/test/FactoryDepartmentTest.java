/**
 * 
 */
package ca.sait.hr.test;

import org.junit.Test;

import ca.sait.hr.dao.DepartmentDAO;
import ca.sait.hr.dao.DepartmentDAOFatory;
import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFatory;
import ca.sait.hr.model.Department;

/**
 * @author honglu
 *
 */
public class FactoryDepartmentTest {

	@Test
	public void createInstance() throws Exception {

		final DepartmentDAO departmentDAO = DepartmentDAOFatory.createInstance();
		
		final Department department = departmentDAO.add("IT");
		
		System.out.println("department: " + department);
	}


}