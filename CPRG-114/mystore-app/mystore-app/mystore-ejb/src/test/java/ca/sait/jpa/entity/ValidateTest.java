/**
 * 
 */
package ca.sait.jpa.entity;

import org.junit.jupiter.api.Test;

import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.entity.AbstractEntity;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.mystore.entity.ProductEntity;
import ca.sait.mystore.entity.RoleEntity;
import ca.sait.mystore.entity.ShoppingCartEntity;
import ca.sait.mystore.entity.ShoppingCartItemEntity;

/**
 *
 */
public class ValidateTest extends AbstractJPATest {

    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            AbstractEntity.class,
            PersonEntity.class,
            ProductEntity.class,
            RoleEntity.class,
            ShoppingCartEntity.class,
            ShoppingCartItemEntity.class
        };
    }

    @Test
    public void validate() {
        logger().trace("ENTER validate()");
        
        jpa(entityManager -> {
        });
        
        logger().trace("EXIT validate()");
    }
}