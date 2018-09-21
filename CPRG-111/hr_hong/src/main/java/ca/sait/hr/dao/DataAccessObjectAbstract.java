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
 * @author honglu
 *
 */
// extends DataItem see error if use extends Employee is ok, since Type is not
// recongnize, because the abstract class, don't need to implement all the
// interface abstract method
public abstract class DataAccessObjectAbstract<TYPE extends DataItem> implements DataAccessObject<TYPE> {

	private final Class<TYPE> type;

	// create singleton instance since only one database for employee and
	// department. use protected may work for findall, but not good
	private InMemoryDatabase database = InMemoryDatabase.createInstance();

	// not a good design, can get null pointer exception
	// protected DataAccessObjectAbstract() {
	// this(null);
	// }

	protected DataAccessObjectAbstract(Class<TYPE> type) {
		this.type = type;
	}

	@Override
	public void add(TYPE item) {
		database.update(item);

	}

	@Override
	public void update(TYPE item) {
		database.update(item);

	}

	@Override
	public void delete(TYPE item) {
		database.remove(item.getOid());

	}

	// @Override
	// public TYPE findBy(UUID oid) {
	// // TODO Auto-generated method stub
	// return (TYPE) database.find(oid);
	//
	// }

	@Override
	public Optional<TYPE> findBy(UUID oid) throws ObjectNotFoundException {

		final Optional<TYPE> item = findAll().stream().filter(data -> data.getOid().equals(oid)).findFirst();
		
		if (!item.isPresent()) {
			throw new ObjectNotFoundException(oid.toString() + " does not exist");
		}
		
		return item;

	}

	public List<TYPE> findAll() {
		return database.findAll().stream().filter(type::isInstance).map(type::cast).collect(Collectors.toList());
	}

	// protected List<TYPE> findAll(Class<TYPE> type) {
	// return
	// database.findAll().stream().filter(type::isInstance).map(type::cast).collect(Collectors.toList());
	// }

}
