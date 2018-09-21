/**
 * 
 */
package ca.sait.hr.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import ca.sait.hr.model.DataItem;

/**
 * @author honglu
 *
 */
public class InMemoryDatabase {
	// inner class, initialize when need
	// make it private only one create, need to switch to Initialization-on-demand
	// holder idiom, iner class, can define as static or none static, difference is
	// with static don't need to create InmemoryDtabase instance
	private static class DatabaseHolder {
		public final static InMemoryDatabase INSTANCE = new InMemoryDatabase();

	}

	// if put out side, when the program start up , this one initialize when
	// InMoryDatabase instance.
	// private final static InMemoryDatabase INSTANCE = new InMemoryDatabase();
	private final Map<UUID, DataItem> DATABASE;
	// private final Logger logger = LoggerFactory.getLogger(getClass());

	// add static createInstance
	public static InMemoryDatabase createInstance() {
		return DatabaseHolder.INSTANCE;
	}

	// make private to get sigleton instance
	private InMemoryDatabase() {
		DATABASE = new HashMap<>();
	}

	public <T extends DataItem> T find(UUID oid, Class<T> type) {
		return (T) DATABASE.get(oid);
	}
	
	public DataItem find(UUID oid) {
		return DATABASE.get(oid);
	}

	public DataItem remove(UUID oid) {
		return DATABASE.remove(oid);
	}

	public DataItem update(DataItem data) {
		// when use if handle data null, don't need to worries null pointer later
		if (data == null) {
			return null;
		}

		final UUID uuid;
		if (DATABASE.containsValue(data)) {
			//System.out.println("replace");
			uuid = DATABASE.values().stream().filter(item -> item.equals(data)).findFirst().get().getOid();
			DATABASE.remove(uuid);
			return DATABASE.put(data.getOid(), data);
			//return DATABASE.replace(uuid, data); // replace force to get regenerate the object hashcode.
		} else {
			//System.out.println("create");
			return DATABASE.put(data.getOid(), data);
		}

	}

	public java.util.List<DataItem> findAll() {
		return DATABASE.values().stream().collect(Collectors.toList());
	}

	public <T> List<T> findAll(Class<T> type) {
		return DATABASE.values().stream().filter(type::isInstance).map(type::cast).collect(Collectors.toList()); // output
																													// as
																													// a
																													// list
	}

}
