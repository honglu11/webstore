/**
 * 
 */
package ca.sait.hr.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import ca.sait.hr.model.DataItem;
import ca.sait.hr.model.Department;
import ca.sait.hr.model.Employee;

/**
 * @author honglu
 *
 */
public interface DepartmentDAO extends DataAccessObject<Department> {	
	Department add(String name);
}
