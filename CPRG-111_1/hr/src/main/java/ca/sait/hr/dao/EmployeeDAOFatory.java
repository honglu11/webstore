/**
 * 
 */
package ca.sait.hr.dao;

/**
 * @author honglu
 *
 */
public final class EmployeeDAOFatory {
	
	private EmployeeDAOFatory() {
		
	}
	
	public static EmployeeDAO createInstance() {
		return new EmployeeDAOMemoryImpl();
	}

}
