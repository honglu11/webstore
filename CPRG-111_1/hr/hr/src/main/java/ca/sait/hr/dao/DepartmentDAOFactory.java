/**
 * 
 */
package ca.sait.hr.dao;

/**
 * @author celias
 *
 */
public final class DepartmentDAOFactory {
	
	private DepartmentDAOFactory() {
	}
	
	public static DepartmentDAO createInstance() {
		return new DepartmentDAOMemoryImpl();
	}

}
