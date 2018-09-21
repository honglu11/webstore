/**
 * 
 */
package ca.sait.hr.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import ca.sait.hr.database.InMemoryDatabase;
import ca.sait.hr.model.DataItem;
import ca.sait.hr.model.Employee;

/**
 * @author honglu
 *
 */
public class DAOMemoryImpl<T extends DataItem>
implements DataAccessObject<T> {
	
	private final Class<T> type;
	
	// create singleton instance since only one database for employee and department.
	protected InMemoryDatabase database = InMemoryDatabase.createInstance();
				
	protected DAOMemoryImpl(Class<T> type) {
		this.type = type;
	}
	// make this one protected, then can create whatever you want.
//	protected EmployeeDAOMemoryImpl() {
//		
//	}
	/* (non-Javadoc)
	 * @see ca.sait.hr.dao.EmployeeDAO#add(ca.sait.hr.model.Employee)
	 */
	@Override
	public void add(T item) {
	  database.update(item);

	}
	
	/* (non-Javadoc)
	 * @see ca.sait.hr.dao.EmployeeDAO#update(ca.sait.hr.model.Employee)
	 */
	@Override
	public void update(T item) {
		database.update(item);

	}

	/* (non-Javadoc)
	 * @see ca.sait.hr.dao.EmployeeDAO#delete(ca.sait.hr.model.Employee)
	 */
	@Override
	public void delete(T item) {
		database.remove(item.getOid());

	}

	/* (non-Javadoc)
	 * @see ca.sait.hr.dao.EmployeeDAO#findBy(java.util.UUID)
	 */

	public T findBy(UUID oid) {
		return database.find(oid, type);
	}

	/* (non-Javadoc)
	 * @see ca.sait.hr.dao.EmployeeDAO#findAll()
	 */
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return database.findAll(type);
	}

}
