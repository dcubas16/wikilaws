package org.wikilaws.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wikilaws.entities.Role;

@Transactional(propagation = Propagation.REQUIRED)
public interface RoleDAO {  
    
    public Role getRole(int id);  
  
}