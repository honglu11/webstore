/**
 * 
 */
package ca.sait.produce;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Chris Elias
 */
public class FinishedProduct extends Product {

    private final static long baseItemId = 21100000;

    private List<RawMaterial> rawMaterials;
    
    /**
     * @param name
     */
    public FinishedProduct(String name) {
        this(name, new LinkedList<RawMaterial>());
    }
    
    /**
     * 
     * @param name
     * @param rawMaterials
     */
    public FinishedProduct(String name, List<RawMaterial> rawMaterials) {
        super(name);
        this.rawMaterials = rawMaterials;
    }

    public List<RawMaterial> getRawMaterials() {
        return rawMaterials;
    }
    
    @Override
    public String getSKU() {
        return null;
    }
    
    @Override
    protected long getBaseItemId() {
        return baseItemId;
    }
}
