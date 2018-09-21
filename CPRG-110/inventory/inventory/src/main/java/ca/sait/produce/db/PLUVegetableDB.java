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
 * This holds the definitions of the Vegatables
 * 
 * @author 
 * @version 1.0
 */
public class PLUVegetableDB {

    private static final Map<String,Map<String,String>> PLU_CODES = 
            new HashMap<String, Map<String,String>>(); 
    
    // Populate the "Database"
    static {
        final Map<String, String> onionsVarieties = new HashMap<String,String>();
        
        onionsVarieties.put("Top Spanish", "4841");
        onionsVarieties.put("Colossal", "4667");
        onionsVarieties.put("Green-Red", "3240");
        onionsVarieties.put("Pearl, Red", "4668");
        onionsVarieties.put("Pickling, Red", "4666");
        
        PLU_CODES.put("Onions", onionsVarieties);
        
        final Map<String, String> lettuceVarieties = new HashMap<String,String>();
        lettuceVarieties.put("Oak Leaf, Hydroponic", "4844");
        
        PLU_CODES.put("Lettuce", lettuceVarieties);
        
        final Map<String, String> spinachVarieties = new HashMap<String,String>();
        spinachVarieties.put("Baby", "4749");

        PLU_CODES.put("Spinach", spinachVarieties);

        final Map<String, String> peppersVarieties = new HashMap<String,String>();
        peppersVarieties.put("Black", "4712");
        peppersVarieties.put("Cayenne", "3198");
        peppersVarieties.put("Floral", "3199");
        peppersVarieties.put("Hot, Yellow", "4718");

        PLU_CODES.put("Peppers", peppersVarieties);
    }
    
    /**
     * 
     * @return
     */
    public static Set<String> getVegetables() {
        return PLU_CODES.keySet();
    }

    /**
     * 
     * @param vegetable
     * @return
     * @throws InvalidCommodityException
     */
    public static Set<String> getVarieties(String vegetable)
    throws InvalidCommodityException {
        final Map<String,String> varieties = PLU_CODES.get(vegetable);
        
        if (varieties == null) {
            throw new InvalidCommodityException(vegetable);
        }
        
        return varieties.keySet();
    }
    
    /**
     * 
     * @param vegetable
     * @param variety
     * @return
     * @throws InvalidCommodityException
     */
    public static String getPLUCode(String vegetable, String variety)
    throws InvalidCommodityException, InvalidVarietyException {
        final Map<String,String> varieties = PLU_CODES.get(vegetable);
        
        if (varieties == null) {
            throw new InvalidCommodityException(vegetable);
        }
        
        final String pluCode = varieties.get(variety);
        
        if (pluCode == null) {
            throw new InvalidVarietyException(variety);
        }
        
        return pluCode;
    }
}
