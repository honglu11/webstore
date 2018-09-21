/**
 * 
 */
package ca.sait.produce.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ca.sait.cli.ValidationException;
import ca.sait.produce.Item;

/**
 * This is an in-memory "database" with some very simple 
 * functions
 * 
 * @author 
 * @version 1.0
 */
public final class InventoryDB {

    private static Map<InventoryItem,InventoryItem> ITEMS = new HashMap<>();
    
    private InventoryDB() {
    }

    /**
     * 
     * @return
     */
    public static Set<InventoryItem> getAll() {
        return ITEMS.keySet();
    }
    
    /**
     * 
     * @param itemId
     * @return
     */
    public static boolean removeItem(long itemId) {
        Iterator<InventoryItem> it = ITEMS.keySet().iterator();
        
        while (it.hasNext()) {
            InventoryItem item = it.next();
            if (itemId == item.getItem().getItemId()) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 
     * @param index
     * @return
     */
    public static InventoryItem getItem(Item item) {
        return ITEMS.get(new InventoryItem(item, 0));
    }
    
    /**
     * Returns an InventoryItem object
     * 
     * @param itemId
     *          the itemId to look for
     * @return
     *          the inventoryItem object
     */
    public static InventoryItem getItem(long itemId) {
        Iterator<InventoryItem> it = ITEMS.keySet().iterator();

        while (it.hasNext()) {
            InventoryItem item = it.next();

            if (item.getItem().getItemId() == itemId) {
                return item;
            }
        }
        
        return null;
    }
    
    
    /**
     * 
     * @param item-
     * @param quantity
     */
    public static void addItem(Item item, int quantity)
    throws ValidationException {
        
        InventoryItem inventory = getItem(item);
        
        if (inventory == null) {
            inventory = new InventoryItem(item, quantity);
            ITEMS.put(inventory,inventory);
        } else {
            inventory.addQuantity(quantity);
        }
    }
}