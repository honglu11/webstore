/**
 * 
 */
package ca.sait.hr.dao;

/**
 * @author honglu
 *
 */
public final class DepartmentDAOFatory {
	
	private DepartmentDAOFatory() {
		
	}
	
	public static DepartmentDAO createInstance() {
		return new DepartmentDAOMemoryImpl();
	}

}
