/**
 * 
 */
package ca.sait.produce;

import ca.sait.produce.db.PLUFruitDB;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 */
public class Fruit extends Produce {

    private final static long baseItemId = 10100000;
    
    /**
     * @param name
     */
    protected Fruit(String name) {
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
            return PLUFruitDB.getPLUCode(getName(), getVariety());
        } catch (InvalidCommodityException | InvalidVarietyException e) {
            // silent catch - 
        }
        
        return null;
    }    
}