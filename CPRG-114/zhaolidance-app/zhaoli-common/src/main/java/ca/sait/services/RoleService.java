/**
 * 
 */
package ca.sait.services;

import java.util.List;
import java.util.UUID;

import ca.sait.dto.Role;

/**
 *
 */
public interface RoleService {

    /**
     * 
     * @param person
     */
    public UUID create(Role role);
    
    /**
     * 
     * @param findByEmail
     */
    public Role findByName(String name);
    
    /**
     * 
     * @param id
     */
    public Role findById(UUID id);
    
    /**
     * 
     * @return
     */
    public List<Role> findAll();
}
