package ca.sait;

import java.util.Calendar;
import java.util.Set;

import org.junit.Test;

import ca.sait.produce.Fruit;
import ca.sait.produce.Item;
import ca.sait.produce.Produce;
import ca.sait.produce.Vegetable;
import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.db.InventoryItem;

/**
 * This is a simple java class to show how to create an instance of a Fruit and Vegetable
 * object and add it to the database  
 *
 */
public class TestDB {

    @Test
    public void doTest() 
    throws Exception {

        final String commodityF = "Apples";
        final String varietyF = "Artlet";
        
        final String commodityV = "Onions";
        final String varietyV = "Colossal";

        
        final Calendar harvestDate = Calendar.getInstance();
        
        // create a few instances of Fruit and Vegetable objects
        final Fruit fruit = (Fruit)Produce.createInstance(true, commodityF, varietyF, harvestDate.getTime());
        final Vegetable veg = (Vegetable)Produce.createInstance(false, commodityV, varietyV, harvestDate.getTime());
        harvestDate.set(2015, 10, 10);
        final Fruit fruit1 = (Fruit)Produce.createInstance(true, commodityF, varietyF, harvestDate.getTime());
        final Vegetable veg1 = (Vegetable)Produce.createInstance(false, commodityV, varietyV, harvestDate.getTime());
        harvestDate.set(2015, 10, 11);
        final Fruit fruit2 = (Fruit)Produce.createInstance(true, commodityF, varietyF, harvestDate.getTime());
        final Vegetable veg2 = (Vegetable)Produce.createInstance(false, commodityV, varietyV, harvestDate.getTime());
        harvestDate.set(2015, 10, 12);
        final Fruit fruit3 = (Fruit)Produce.createInstance(true, commodityF, varietyF, harvestDate.getTime());
        final Vegetable veg3 = (Vegetable)Produce.createInstance(false, commodityV, varietyV, harvestDate.getTime());
        
        // the items to the database.
        InventoryDB.addItem(fruit1, 1);
        InventoryDB.addItem(fruit2, 2);
        InventoryDB.addItem(fruit3, 3);
        InventoryDB.addItem(fruit, 4);
        InventoryDB.addItem(veg1, 1);
        InventoryDB.addItem(veg2, 2);
        InventoryDB.addItem(veg3, 3);
        InventoryDB.addItem(veg, 4);
        
        // get all items in the database
        Set<InventoryItem> inventory = InventoryDB.getAll();
        
        // loop through all items
        inventory.forEach(inv -> {
            Item item = inv.getItem();
            int quantity = inv.getQuantity();
            
            System.out.println("item id:" + item.getItemId() + " - " + item.toString() + " - Qty " + quantity);
        });
    }
}