/**
 * 
 */
package ca.sait.mystore.ejb;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import ca.sait.dto.Role;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.entity.RoleEntity;
import ca.sait.services.RoleService;

/**
 * @author Chris Elias
 *
 */
@Stateless
@Local(RoleService.class)
public class RoleServiceImpl 
implements RoleService {

    @EJB
    private DAOManagerFactory daoFactory;
    
    /* (non-Javadoc)
     * @see ca.sait.services.PersonService#create(ca.sait.dto.Person)
     */
    @Override
    public UUID create(Role role) {
        final RoleEntity entity = new RoleEntity();
        entity.setDescription(role.getDescription());
        entity.setRoleName(role.getName());
        
        daoFactory.getRoleDAO().persist(entity);

        return entity.getOid();
    }

    /* (non-Javadoc)
     * @see ca.sait.services.RoleService#findByName(java.lang.String)
     */
    @Override
    public Role findByName(String name) {
        return daoFactory.getRoleDAO().findByNameDTO(name);
    }

    /* (non-Javadoc)
     * @see ca.sait.services.RoleService#findById(java.util.UUID)
     */
    @Override
    public Role findById(UUID id) {
         return daoFactory.getRoleDAO().findDTO(id);
    }

    /* (non-Javadoc)
     * @see ca.sait.services.RoleService#findAll()
     */
    @Override
    public List<Role> findAll() {
        return daoFactory.getRoleDAO().findAllDTO();
    }
}