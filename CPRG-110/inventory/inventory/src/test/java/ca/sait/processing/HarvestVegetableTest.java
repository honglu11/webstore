/**
 * 
 */
package ca.sait.processing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import ca.sait.produce.Produce;
import ca.sait.produce.Vegetable;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 */
public class HarvestVegetableTest {

    @Test
    public void createOnion() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Onions";
        final String variety = "Colossal";
        final Date harvestDate = new Date();
        
        final Vegetable veg = (Vegetable)Produce.createInstance(false, commodity, variety, harvestDate);
        
        assertNotNull("Vegetable object was not created", veg);

        // test to make sure a vegetable object was created
        final String prefix = Long.toString(veg.getItemId()).substring(0,3);
        
        // test to make sure the vegetable object has the correct 3 digit prefix
        assertEquals("Wrong prefix", "201", prefix);
    }

    @Test(expected=InvalidCommodityException.class)
    public void createWithInvalidCommodity() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Chicken";
        final String variety = "Colossal";
        final Date harvestDate = new Date();
        
        final Vegetable veg = (Vegetable)Produce.createInstance(false, commodity, variety, harvestDate);
        
        assertNull("Vegetable object was created", veg);
    }

    @Test(expected=InvalidVarietyException.class)
    public void createWithInvalidVariety() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Onions";
        final String variety = "Chicken";
        final Date harvestDate = new Date();
        
        final Vegetable veg = (Vegetable)Produce.createInstance(false, commodity, variety, harvestDate);
        
        assertNull("Vegetable object was created", veg);
    }

    @Test(expected=NullPointerException.class)
    public void createWithInvalidHarvestDate() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Onions";
        final String variety = "Colossal";
        final Date harvestDate = null;
        
        final Vegetable veg = (Vegetable)Produce.createInstance(false, commodity, variety, harvestDate);
        
        assertNull("Vegetable object was created. Nullpointer Exception should have been thrown for invalid harvest date", veg);
    }
}