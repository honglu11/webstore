/**
 * 
 */
package ca.sait.cli.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import ca.sait.cli.Main;
import ca.sait.cli.ValidationException;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 * @version 1.0
 */
public class ListCommandTest extends AbstractBase {
    
    @Rule
    public Timeout globalTimeout = new Timeout(3, TimeUnit.SECONDS);
    
    /**
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     * 
     */
    @Test
    public void listItems() throws InvalidCommodityException, InvalidVarietyException, ValidationException {
    	
        sendCommands("HF\n", 
                     "Apples\n", "Artlet\n", "10\n","2014-12-12\n", 
                     "LIST\n",
                     "Exit\n");

        new Main().run();
        
        final String output = getOutput().toLowerCase();

        assertTrue("item id not in result", output.toLowerCase().contains("item id"));
        assertTrue("{commodity-variety} not in result", output.toLowerCase().contains("apples-artlet"));
        assertTrue("harvest date not in result", output.toLowerCase().contains("harvest date"));
        assertTrue("harvest date value not in result", output.toLowerCase().contains("2014-12-12"));
        assertTrue("Quantity is not in result", output.toLowerCase().contains("quantity"));
    }

    @Override
    protected void testCommandClass() {
        try {
            final Class<?> listCommandClass = Class.forName("ca.sait.cli.ListCommand");
            listCommandClass.newInstance();
            fail("ListCommand has a Default Constructor");
        } catch (final ClassNotFoundException e ) {
            fail("ListCommand class does not Exist");
        } catch (final InstantiationException| IllegalAccessException e) {
            // No default Constructor, this is good
        }
        
        try {
            final Class<?> inventoryDBClass = Class.forName("ca.sait.produce.db.InventoryDB");
            inventoryDBClass.newInstance();
            fail("InventoryDB has a Default Constructor");
        } catch (final ClassNotFoundException e ) {
            fail("ca.sait.produce.db.Inventory class does not Exist");
        } catch (final InstantiationException| IllegalAccessException e) {
            // No default Constructor, this is good
        }

        try {
            final Class<?> inventoryDBClass = Class.forName("ca.sait.produce.db.InventoryItem");
            inventoryDBClass.newInstance();
            fail("InventoryItem has a Default Constructor");
        } catch (final ClassNotFoundException e ) {
            fail("ca.sait.produce.db.InventoryItem class does not Exist");
        } catch (final InstantiationException| IllegalAccessException e) {
            // No default Constructor, this is good
        }        
    }
}