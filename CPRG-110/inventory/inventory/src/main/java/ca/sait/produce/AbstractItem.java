/**
 * 
 */
package ca.sait.produce;

/**
 * 
 * @author Chris Elias
 */
public abstract class AbstractItem implements Item {

    private final String name;
    private final long itemId;
    
    /**
     * 
     */
    public AbstractItem(String name) {
        this.name = name;
        itemId = getBaseItemId() + getNextCounter();
    }

    /**
     * 
     * @return
     */
    protected abstract long getBaseItemId();
    
    /**
     * 
     * @return
     */
    protected abstract long getNextCounter();
    
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public Long getItemId() {
        return itemId;
    }
    
    @Override
    public String toString() {
        return getItemId() + " - " + getName();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (itemId ^ (itemId >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractItem other = (AbstractItem) obj;
        if (itemId != other.itemId)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        
        return true;
    }
}
