package ca.sait.hr.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import ca.sait.hr.database.InMemoryDatabase;
import ca.sait.hr.model.DataItem;
import ca.sait.hr.model.Department;
import ca.sait.hr.model.Employee;

public class DepartmentDAOMemoryImpl extends DataAccessObjectAbstract<Department>
implements DepartmentDAO {
	
	// make this one protected, then can create whatever you want.
	protected DepartmentDAOMemoryImpl() {
		super(Department.class);
	}

//	@Override
//	public void add(Department department) {
//		database.update(department);
//
//	}
//
	@Override
	public Department add(String name) {
		final Department department = new Department(name);
		add(department);
		return department;
	}
//
//	@Override
//	public void update(Department department) {
//		database.update(department);
//
//	}
//	
//	@Override
//	public void delete(Department department) {
//		database.remove(department.getOid());
//
//	}
//
//	@Override
//	public Department findBy(UUID oid) {
//		// TODO Auto-generated method stub
//		return (Department)database.find(oid);
//	}
//
//	@Override
//	public List<Department> findAll() {
//		// TODO Auto-generated method stub
//		final List<Department> results = new ArrayList<>(database.findAll().size());
//		for ( final DataItem item : database.findAll()) {
//			results.add((Department)item);
//		}
//		return results:
//			
//		return database.findAll().stream().filter(Department.class::isInstance).map(Department.class::cast).collect(Collectors.toList());
//	}
//
//	@Override
//	public void add(Department department, Employee employee) {		
//		
//		department.getEmployees().add(employee);
//		
//	}

}
