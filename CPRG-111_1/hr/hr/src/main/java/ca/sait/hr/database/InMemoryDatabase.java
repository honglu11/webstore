/**
 * 
 */
package ca.sait.hr.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.hr.model.DataItem;

/**
 * @author celias
 *
 */
public class InMemoryDatabase {

	// need to switch to Initialization-on-demand holder idiom
	private static class DatabaseHolder {
		public final static InMemoryDatabase INSTANCE = new InMemoryDatabase();	
	}
	
	private final Map<UUID,DataItem> DATABASE;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static InMemoryDatabase createInstance() {
		return DatabaseHolder.INSTANCE;
	}
	
	/**
	 * 
	 */
	private InMemoryDatabase() {
		logger.debug("Create new database map");
		DATABASE = new HashMap<>();
	}
	
	/**
	 * method to find a specific item in the 
	 * memory database by object id
	 * 
	 * @param oid
	 * 		the object id to find by
	 * @return
	 * 		the item in the database. Null if not
	 * 		found
	 */
	public DataItem find(UUID oid) {
		return DATABASE.get(oid);
	}
	
	/**
	 * Removes an item from the database
	 * 
	 * @param oid
	 * 		the oid of the item to remove
	 * @return
	 * 		the item instance removed from the 
	 * 		database.  NULL if no item removed
	 */
	public DataItem remove(UUID oid) {
		return DATABASE.remove(oid);
	}
	
	/**
	 * The item to update in the database.
	 * 
	 * @param data
	 * 		the object to update
	 * @return
	 * 		the original item. NULL if there
	 * 		was no item in the database
	 */
	public DataItem update(DataItem data) {
		
		if (data == null)
			return null;

		final UUID uuid;
		if (DATABASE.containsValue(data)) {
			uuid = DATABASE.values().stream()
						.filter(item -> item.equals(data))
						.findFirst().get().getOid();
			
			DATABASE.remove(uuid);
			return DATABASE.put(data.getOid(), data);	
		}  else {
			return DATABASE.put(data.getOid(), data);
		}
	}

	/**
	 * returns all the items in the database
	 * @return
	 */
	public List<DataItem> findAll() {
		return DATABASE.values()
			.stream()
			.collect(Collectors.toList());
	}
}