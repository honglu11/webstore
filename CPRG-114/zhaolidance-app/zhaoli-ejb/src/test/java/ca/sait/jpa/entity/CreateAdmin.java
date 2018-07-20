/**
 * 
 */
package ca.sait.jpa.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import ca.sait.dto.Person;
import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.dao.PersonDAO;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.mystore.entity.RoleEntity;

/**
 * @author celias
 *
 */
public class CreateAdmin extends AbstractJPATest {

    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            PersonEntity.class,
            RoleEntity.class
        };
    }

    @Test
    public void create() {
        
        final UUID uuid = jpa(entityManager -> {
            final PersonEntity entity = new PersonEntity();
            entity.setFirstName("Admin");
            entity.setLastName("Admin");
            entity.setPassword("admin");
            entity.setEmail("admin");
            entity.setBirthdate(Date.valueOf(LocalDate.now()));
            
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final PersonDAO dao = daoFactory.getPersonDAO();
            final RoleEntity adminRole = daoFactory.getRoleDAO().findByName("admin");
            
            entity.getRoles().add(adminRole);
            
            return dao.persist(entity);
        });
        
        final Person person = jpa(entityManager -> {
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final PersonDAO dao = daoFactory.getPersonDAO();
            return dao.findDTO(uuid);
        });
        
        logger().info("person: {}", person.getFirstName());
    }
    
    @Test
    public void createGuest() {
        
        final UUID uuid = jpa(entityManager -> {
            final PersonEntity entity = new PersonEntity();
            entity.setFirstName("Guest");
            entity.setLastName("Guest");
            entity.setPassword("guest");
            entity.setEmail("guest");
            entity.setBirthdate(Date.valueOf(LocalDate.now()));
            
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final PersonDAO dao = daoFactory.getPersonDAO();
            final RoleEntity guestRole = daoFactory.getRoleDAO().findByName("guest");
            
            entity.getRoles().add(guestRole);
            
            return dao.persist(entity);
        });
        
        final Person person = jpa(entityManager -> {
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final PersonDAO dao = daoFactory.getPersonDAO();
            return dao.findDTO(uuid);
        });
        
        logger().info("person: {}", person.getFirstName());
    }
}






