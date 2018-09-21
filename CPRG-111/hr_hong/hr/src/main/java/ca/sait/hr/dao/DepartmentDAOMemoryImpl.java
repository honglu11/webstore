/**
 * 
 */
package ca.sait.hr.dao;

import ca.sait.hr.model.Department;

/**
 * @author celias
 *
 */
public class DepartmentDAOMemoryImpl extends DataAccessObjectAbstract<Department>
implements DepartmentDAO {

	protected DepartmentDAOMemoryImpl() {
		super(Department.class);
	}

	@Override
	public Department add(String name) {
		final Department department = new Department(name);
		
		add(department);
		
		return department;
	}
}












