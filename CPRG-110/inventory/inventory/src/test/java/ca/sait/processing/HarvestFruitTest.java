/**
 * 
 */
package ca.sait.processing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import ca.sait.produce.Fruit;
import ca.sait.produce.Produce;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 */
public class HarvestFruitTest {

    @Test
    public void createApple() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Apples";
        final String variety = "Artlet";
        
        final Date harvestDate = new Date();
        final Fruit fruit = (Fruit)Produce.createInstance(true, commodity, variety, harvestDate);
        
        // test to make sure a fruit object was created
        assertNotNull("Fruit object was not created", fruit);
        
        final String prefix = Long.toString(fruit.getItemId()).substring(0,3);
        
        // test to make sure the fruit object has the correct 3 digit prefix
        assertEquals("Wrong prefix", "101", prefix);
    }

    @Test(expected=InvalidCommodityException.class)
    public void createWithInvalidCommodity() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Chicken";
        final String variety = "Artlet";
        
        final Date harvestDate = new Date();
        final Fruit fruit = (Fruit)Produce.createInstance(true, commodity, variety, harvestDate);
        
        assertNull("Fruit object was created", fruit);
    }

    @Test(expected=InvalidVarietyException.class)
    public void createWithInvalidVariety() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Apples";
        final String variety = "Chicken";
        
        final Date harvestDate = new Date();
        final Fruit fruit = (Fruit)Produce.createInstance(true, commodity, variety, harvestDate);
        
        assertNull("Fruit object was created", fruit);
    }

    @Test(expected=NullPointerException.class)
    public void createWithInvalidHarvestDate() 
    throws InvalidCommodityException, InvalidVarietyException {
        final String commodity = "Apples";
        final String variety = "Artlet";
        
        final Date harvestDate = null;
        final Fruit fruit = (Fruit)Produce.createInstance(true, commodity, variety, harvestDate);
        
        assertNull("Fruit object was created. Nullpointer Exception should have been thrown for invalid harvest date", fruit);
    }
}