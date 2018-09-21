/**
 * 
 */
package ca.sait.mystore.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author chris
 *
 */
@Entity(name="ShoppingCart")
@Table(name="CART")
@NamedQueries({
    @NamedQuery(name="Cart.SELECT_ALL", query="SELECT c FROM ShoppingCart c ORDER BY c.startDate DESC"),
    @NamedQuery(name="Cart.FIND_BY_CUSTOMER", query="SELECT c FROM ShoppingCart c WHERE c.customer.email =:email"),
})
public class ShoppingCart extends AbstractEntity {

    private static final long serialVersionUID = -2876517876772030379L;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date", nullable=false)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name="submit_date")
    private Date submitDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name="ship_date")
    private Date shipDate;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_oid")
    private Person customer;
    
    @OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL)
    private List<ShoppingCartItem> items;

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the submitDate
     */
    public Date getSubmitDate() {
        return submitDate;
    }

    /**
     * @param submitDate the submitDate to set
     */
    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    /**
     * @return the shipDate
     */
    public Date getShipDate() {
        return shipDate;
    }

    /**
     * @param shipDate the shipDate to set
     */
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    /**
     * @return the customer
     */
    public Person getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    /**
     * @return the items
     */
    public List<ShoppingCartItem> getItems() {
        if (items == null)
            items = new ArrayList<>();
        
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }    
}