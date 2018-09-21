/**
 * 
 */
package ca.sait.processing;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import ca.sait.produce.FinishedProduct;
import ca.sait.produce.Produce;
import ca.sait.produce.RawMaterial;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 */
public class CreateFinishedProductTest {

    /**
     * Test case to make sure that the constructor is hidden
     * @throws NoSuchMethodException
     */
//    @Test(expected=NoSuchMethodException.class)
//    public void isConstructorHidden()
//    throws NoSuchMethodException {
//        
//        final String commodity = "Apples";
//        final String variety = "Artlet";
//        final Date harvestDate = new Date();
//
//        try {
//            final Produce produce = Produce.createInstance(true, commodity, variety, harvestDate);
//            final RawMaterial rawMaterial = new RawMaterial(produce);
//            
//            final FinishedProduct finished = new FinishedProduct("Mushed Apples");
//            finished.getRawMaterials().add(rawMaterial);
//            
//            
//            assertNull("RawMaterial Instance was created. The constructor should be hidden!", rawMaterial.getSKU());
//        } catch (InvalidCommodityException | InvalidVarietyException ex) {
//            fail("Unable to create a Produce object: " + ex.getMessage());
//        }
//    }
}