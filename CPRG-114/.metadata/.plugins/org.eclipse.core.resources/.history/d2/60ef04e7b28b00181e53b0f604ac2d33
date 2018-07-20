/**
 * 
 */
package ca.sait.jpa.entity;

import org.junit.jupiter.api.Test;

import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.dao.RoleDAO;
import ca.sait.mystore.entity.RoleEntity;

/**
 * @author celias
 *
 */
public class CreateRoles extends AbstractJPATest {

    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            RoleEntity.class
        };
    }

    @Test
    public void create() {
        
        jpa(entityManager -> {

            final RoleEntity adminRole = new RoleEntity();
            final RoleEntity guestRole = new RoleEntity();
            
            adminRole.setRoleName("admin");
            adminRole.setDescription("Adminstrator of the site");

            guestRole.setRoleName("guest");
            guestRole.setDescription("Consumer of the shopping site");

            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final RoleDAO dao = daoFactory.getRoleDAO();
            dao.persist(adminRole);
            dao.persist(guestRole);
        });
        
        
    }
    
    @Test
    public void createMore() {
        
        jpa(entityManager -> {

            final RoleEntity adminRole = new RoleEntity();
            final RoleEntity guestRole = new RoleEntity();
            
            adminRole.setRoleName("student");
            adminRole.setDescription("Student of the site");

            guestRole.setRoleName("teacher");
            guestRole.setDescription("Teacher of the shopping site");

            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final RoleDAO dao = daoFactory.getRoleDAO();
            dao.persist(adminRole);
            dao.persist(guestRole);
        });
        
        
    }
}






