/**
 * 
 */
package ca.sait.hr.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import ca.sait.hr.database.InMemoryDatabase;
import ca.sait.hr.model.DataItem;

/**
 * @author celias
 *
 */
public abstract class DataAccessObjectAbstract<TYPE extends DataItem> 
implements DataAccessObject<TYPE> {

	private InMemoryDatabase database = InMemoryDatabase.createInstance();
	private final Class<TYPE> type;
	
	protected DataAccessObjectAbstract(Class<TYPE> type) {
		this.type = type;
	}
	
	@Override
	public void add(TYPE data) {
		database.update(data);
	}
	
	@Override
	public void update(TYPE data) {
		database.update(data);
	}
	
	@Override
	public void delete(TYPE data) {
		database.remove(data.getOid());
	}

	@Override
	public Optional<TYPE> findBy(UUID oid) 
	throws ObjectNotFoundException {
		final Optional<TYPE> item = findAll().stream()
					.filter(data -> data.getOid().equals(oid))
					.findFirst();
		
		if (!item.isPresent())
			throw new ObjectNotFoundException(oid.toString() + " does not exist");
		
		return item;
	}

	public List<TYPE> findAll() {
		return database.findAll()
				.stream()
				.filter(type::isInstance)
				.map(type::cast)
				.collect(Collectors.toList());
	}
}











