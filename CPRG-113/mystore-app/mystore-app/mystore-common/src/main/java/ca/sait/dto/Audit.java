/**
 * 
 */
package ca.sait.dto;

import java.util.Date;

/**
 * @author Chris Elias
 *
 */
public class Audit {

    private final Date createDate;
    private final Date lastModified;
    private final String createdBy;
    private final String lastModifiedBy;
    
    public Audit(Date createDate, Date lastModified,
            String createdBy, String lastModifiedBy) {
        
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return the lastModifiedBy
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @return the lastModified
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }
}