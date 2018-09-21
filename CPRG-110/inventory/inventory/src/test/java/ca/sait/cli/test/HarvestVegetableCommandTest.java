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
public class HarvestVegetableCommandTest extends AbstractBase {
    
    @Rule
    public Timeout globalTimeout = new Timeout(3, TimeUnit.SECONDS);

    /**
     * Test the create a vegetable 
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     */
    @Test
    public void createVegetable() throws InvalidCommodityException, InvalidVarietyException, ValidationException {
        System.out.println("\n\nTest - Create Vegetable");
        System.out.println("-------------------");
        
        sendCommands("HV\n", "Onions\n", "Colossal\n", "10\n","2014-12-12\n", "Exit\n");
        new Main().run();
        
        final String output = getOutput().toLowerCase();

        assertTrue("Response does not contain text Created {commodity}-{variety}", 
                output.toLowerCase().contains("created onions-colossal"));
    }

    /**
     * Test case for handling invalid quantity 
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     */
    @Test
    public void invalidEntryQuantity() throws InvalidCommodityException, InvalidVarietyException, ValidationException {
        System.out.println("\n\nTest - Create Vegetable - Invalid Quantity");
        System.out.println("-------------------");

        sendCommands("HV\n", "Onions\n", "Colossal\n", "A0\n",
                             "Onions\n", "Colossal\n", "10\n","2014-12-12\n", "Exit\n");
        new Main().run();
        
        final String output = getOutput().toLowerCase();

        assertTrue("Does not contain error message \"Invalid Number for Quantity\"", 
                output.toLowerCase().contains("invalid number for quantity"));

        assertTrue("Response does not contain text Created {commodity}-{variety}", 
                output.toLowerCase().contains("created onions-colossal"));
    }

    /**
     * Test case for handling invalid harvest date 
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     */
    @Test
    public void invalidEntryHarvestDate() throws InvalidCommodityException, InvalidVarietyException, ValidationException {
        System.out.println("\n\nTest - Create Vegetable - Invalid Harvest Date");
        System.out.println("-------------------");

        sendCommands("HV\n", "Onions\n", "Colossal\n", "10\n", "2014-APR\n",
                             "Onions\n", "Colossal\n", "10\n", "2014-12-12\n", "Exit\n");
        new Main().run();
        
        final String output = getOutput().toLowerCase();

        assertTrue("Does not contain error message \"unparseable date\"", 
                output.toLowerCase().contains("unparseable date"));

        assertTrue("Response does not contain text Created {commodity}-{variety}", 
                output.toLowerCase().contains("created onions-colossal"));

    }

    @Override
    protected void testCommandClass() {
        try {
            final Class<?> helpClass = Class.forName("ca.sait.cli.HarvestVegetableCommand");
            helpClass.newInstance();
            fail("CreateFruitCommand has a Default Constructor");
        } catch (final ClassNotFoundException e ) {
            fail("CreateFruitCommand class does not Exist");
        } catch (final InstantiationException| IllegalAccessException e) {
            // No default Constructor, this is good
        }
    }
}