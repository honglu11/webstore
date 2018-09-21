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
import ca.sait.produce.FinishedProduct;
import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.db.InventoryItem;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 * @version 1.0
 */
public class CreateFinishedProductCommandTest extends AbstractBase {
    
    @Rule
    public Timeout globalTimeout = new Timeout(3, TimeUnit.SECONDS);

    /**
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     * 
     */
    @Test
    public void createFinishedProduct() throws InvalidCommodityException, InvalidVarietyException, ValidationException, Exception {
        sendCommands("HF\n", 
                "Apples\n", "Artlet\n", "10\n","2014-12-12\n",
                "CR\n","10100000\n",
                "CP\n","FruitCocktail\n","11100000\n","-1\n",
                "LIST\n",
                "Exit\n");

        new Main().run();
   
        final String output = getOutput().toLowerCase();

        assertTrue("item id not in result", output.toLowerCase().contains("item id"));
        assertTrue("{commodity-variety} not in result", output.toLowerCase().contains("apples-artlet"));
        assertTrue("harvest date not in result", output.toLowerCase().contains("harvest date"));
        assertTrue("harvest date value not in result", output.toLowerCase().contains("2014-12-12"));
        assertTrue("Quantity is not in result", output.toLowerCase().contains("quantity"));
        
        boolean hasFinishedProduct = false;
        for (final InventoryItem item : InventoryDB.getAll()) {
            if (item.getItem() instanceof FinishedProduct) {
                hasFinishedProduct = true;
            }
        }
        
        assertTrue("No FinishedProduct Object in inventory", hasFinishedProduct);

    }

    @Override
    protected void testCommandClass() {
        try {
            final Class<?> commandClass = Class.forName("ca.sait.cli.CreateFinishedProductCommand");
            commandClass.newInstance();
            fail("CreateFinishedProductCommand has a Default Constructor");
        } catch (final ClassNotFoundException e ) {
            fail("CreateFinishedProductCommand class does not Exist");
        } catch (final InstantiationException| IllegalAccessException e) {
            // No default Constructor, this is good
        }
    }
}