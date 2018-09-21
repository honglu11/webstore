/**
 * 
 */
package ca.sait.produce;

import java.text.SimpleDateFormat;
import java.util.Date;

import ca.sait.produce.db.PLUFruitDB;
import ca.sait.produce.db.PLUVegetableDB;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 */
public abstract class Produce extends AbstractItem {

    private static long produceCounter = 0;
    
    private Date harvestDate;
    private String variety;
    
    /**
     * 
     */
    public Produce(String name) {
        super(name);
    }

    /**
     * 
     * @return
     */
    public abstract String getPLU();

    @Override
    protected long getNextCounter() {
        return produceCounter++;
    }

    /**
     * @return the harvestDate
     */
    public Date getHarvestDate() {
        return harvestDate;
    }

    /**
     * @param harvestDate the harvestDate to set
     */
    public void setHarvestDate(Date harvestDate) {
        this.harvestDate = harvestDate;
    }

    /**
     * @return the variety
     */
    public String getVariety() {
        return variety;
    }

    /**
     * @param variety the variety to set
     */
    public void setVariety(String variety) {
        this.variety = variety;
    }
    
    /**
     * 
     * @param isFruit
     * @param name
     * @param variety
     * @param harvestDate
     * @return
     * 
     * @throws InvalidCommodityException
     * @throws InvalidVarietyException
     */
    public static Produce createInstance(boolean isFruit, String name, String variety, Date harvestDate)
    throws InvalidCommodityException, InvalidVarietyException {

        final Produce produce;
        
        if (isFruit) {
            PLUFruitDB.getPLUCode(name, variety);
            produce = new Fruit(name);
        } else {
            PLUVegetableDB.getPLUCode(name, variety);
            produce = new Vegetable(name);
        }

        produce.setVariety(variety);
        produce.setHarvestDate(harvestDate);
        
        return produce;
    }
    
    @Override
    public String toString() {
        
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("%s-%s Harvest Date: %s", getName(), getVariety(),
                formatter.format(getHarvestDate()));
    }
}