/**
 * 
 */
package ca.sait.produce.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * This holds the definitions of the Fruits
 * 
 * @author 
 * @version 1.0
 */
public class PLUFruitDB {

    private static final Map<String,Map<String,String>> PLU_CODES = 
            new HashMap<String, Map<String,String>>(); 
    
    // Populate the "Database"
    static {
        final Map<String, String> appleVarieties = new HashMap<String,String>();
        
        appleVarieties.put("Artlet", "4205");
        appleVarieties.put("Cortland", "4296");
        appleVarieties.put("Empire", "4214");
        appleVarieties.put("Gala", "4211");
        appleVarieties.put("Golden", "4215");
        appleVarieties.put("McIntosh", "4216");
        
        PLU_CODES.put("Apples", appleVarieties);
        
        final Map<String, String> apricotsVarieties = new HashMap<String,String>();
        apricotsVarieties.put("Tree Ripe", "4219");
        
        PLU_CODES.put("Apricots", apricotsVarieties);
        
        final Map<String, String> cactusPearsVarieties = new HashMap<String,String>();
        cactusPearsVarieties.put("Flat", "4477");

        PLU_CODES.put("Cactus Pears", cactusPearsVarieties);

        final Map<String, String> grapesVarieties = new HashMap<String,String>();
        grapesVarieties.put("Barlinka", "4276");
        grapesVarieties.put("Coronation", "4277");
        grapesVarieties.put("Italia Black", "3093");
        grapesVarieties.put("Wine", "3094");

        PLU_CODES.put("Grapes", grapesVarieties);
    }
    
    /**
     * 
     * @return
     */
    public static Set<String> getFruits() {
        return PLU_CODES.keySet();
    }

    /**
     * 
     * @param fruit
     * @return
     * @throws InvalidCommodityException
     */
    public static Set<String> getVarieties(String fruit)
    throws InvalidCommodityException {
        final Map<String,String> varieties = PLU_CODES.get(fruit);
        
        if (varieties == null) {
            throw new InvalidCommodityException(fruit);
        }
        
        return varieties.keySet();
    }
    
    /**
     * 
     * @param fruit
     * @param variety
     * @return
     * @throws InvalidCommodityException
     */
    public static String getPLUCode(String fruit, String variety)
    throws InvalidCommodityException, InvalidVarietyException {
        final Map<String,String> varieties = PLU_CODES.get(fruit);
        
        if (varieties == null) {
            throw new InvalidCommodityException(fruit);
        }
        
        final String pluCode = varieties.get(variety);
        
        if (pluCode == null) {
            throw new InvalidVarietyException(variety);
        }
        
        return pluCode;
    }
}
