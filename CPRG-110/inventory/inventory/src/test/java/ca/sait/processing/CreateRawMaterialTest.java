/**
 * 
 */
package ca.sait.processing;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import ca.sait.cli.ValidationException;
import ca.sait.produce.Produce;
import ca.sait.produce.RawMaterial;
import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 */
public class CreateRawMaterialTest {

    /**
     * Test case to make sure that the constructor is hidden
     * @throws NoSuchMethodException
     */
    @Test
    public void createRawMaterial()
    throws NoSuchMethodException {
        
        final String commodity = "Apples";
        final String variety = "Artlet";
        final Date harvestDate = new Date();

        try {
            final Produce produce = Produce.createInstance(true, commodity, variety, harvestDate);
            final RawMaterial rawMaterial = new RawMaterial(produce);
            
            InventoryDB.addItem(rawMaterial, 1);
        } catch (InvalidCommodityException | InvalidVarietyException ex) {
            fail("Unable to create a Produce object: " + ex.getMessage());
        } catch (ValidationException ex) {
            fail("Invalid Inventory Quantity: " + ex.getMessage());
        }
    }
}










