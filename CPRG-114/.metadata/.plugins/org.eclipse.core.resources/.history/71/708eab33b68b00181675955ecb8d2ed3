/**
 * 
 */
package ca.sait.mystore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ca.sait.dto.CartStatus;

/**
 *
 * @author Chris Elias
 * @author Alberta Utility Billing
 */
@Entity(name="ShoppingCart")
@Table(name="shopping_cart")
public class ShoppingCartEntity extends AbstractEntity {

    @ManyToOne(optional=false)
    @JoinColumn(name="person_oid", nullable=false, updatable=false)
    private PersonEntity customer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="shopping_date", nullable=false)
    private Date shoppingDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="shipped_date", nullable=true)
    private Date shippedDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="recieved_date", nullable=true)
    private Date recievedDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name="cart_status", nullable=true)
    private CartStatus status;
    
}
