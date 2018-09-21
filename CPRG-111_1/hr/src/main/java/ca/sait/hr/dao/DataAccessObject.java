package ca.sait.hr.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ca.sait.hr.model.DataItem;
import ca.sait.hr.model.Department;
import ca.sait.hr.model.Employee;

public interface DataAccessObject<T extends DataItem> {
	// DataAccessObject<T extends DataItem, V>
	void add(T item);
	void update(T item);
	void delete(T item);
	
	Optional<T> findBy(UUID oid) throws ObjectNotFoundException;
	List<T> findAll(); // list does not take a lot of memory

	// by add T extends DataItem, prevent that use something like DataAccessObject<String>
}
