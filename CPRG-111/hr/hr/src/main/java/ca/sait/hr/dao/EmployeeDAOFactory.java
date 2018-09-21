/**
 * 
 */
package ca.sait.hr.dao;

/**
 * @author celias
 *
 */
public final class EmployeeDAOFactory {
	
	private EmployeeDAOFactory() {
	}
	
	public static EmployeeDAO createInstance() {
		return new EmployeeDAOMemoryImpl();
	}

}
