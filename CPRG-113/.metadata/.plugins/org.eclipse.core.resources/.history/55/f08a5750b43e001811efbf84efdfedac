/**
 * 
 */
package ca.sait.jpa.entity;

import java.util.Date;

import org.junit.jupiter.api.Test;

import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.entity.PersonEntity;

/**
 * @author celias
 *
 */
public class PersonTest extends AbstractJPATest {

    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            PersonEntity.class
        };
    }

    @Test
    public void create() {
        jpa(entityManager -> {
            final PersonEntity entity = new PersonEntity();
            entity.setBirthdate(new Date());
            entity.setFirstName("chris");
            entity.setLastName("Elias");
            
            entityManager.persist(entity);
        });
    }
}






