package org.wikilaws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wikilaws.dao.RoleDAO;
import org.wikilaws.entities.Role;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired  
    private RoleDAO roleDAO;  
  
    public Role getRole(int id) {  
    	
        return roleDAO.getRole(id);  
    }  
}
