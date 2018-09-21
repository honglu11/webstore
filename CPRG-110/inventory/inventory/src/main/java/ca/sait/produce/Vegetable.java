/**
 * 
 */
package ca.sait.produce;

import ca.sait.produce.db.PLUVegetableDB;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 */
public class Vegetable extends Produce {

    private final static long baseItemId = 20100000;
    
    /**
     * @param name
     */
    protected Vegetable(String name) {
        super(name);
    }
    
    /*
     * (non-Javadoc)
     * @see ca.sait.produce.AbstractItem#getBaseItemId()
     */
    @Override
    protected long getBaseItemId() {
        return baseItemId;
    }
    
    /* (non-Javadoc)
     * @see ca.sait.produce.Produce#getPLU()
     */
    @Override
    public String getPLU() {
        try {
            return PLUVegetableDB.getPLUCode(getName(), getVariety());
        } catch (InvalidCommodityException | InvalidVarietyException e) {
            // silent catch - 
        }
        
        return null;
    }
}