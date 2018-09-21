/**
 * 
 */
package ca.sait.hr.dao;

import ca.sait.hr.model.Department;

/**
 * @author celias
 *
 */
public interface DepartmentDAO
extends DataAccessObject<Department> {
	
	Department add(String name);
}














