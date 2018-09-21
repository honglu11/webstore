/**
 * 
 */
package ca.sait.hr.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ca.sait.hr.model.DataItem;

/**
 * @author celias
 *
 */
public interface DataAccessObject<TYPE extends DataItem> {

	void add(TYPE item);
	void update(TYPE item);
	void delete(TYPE item);
	Optional<TYPE> findBy(UUID oid) throws ObjectNotFoundException;
	
	List<TYPE> findAll();

}
