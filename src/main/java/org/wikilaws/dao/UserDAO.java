package org.wikilaws.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wikilaws.entities.User;

@Transactional(propagation = Propagation.REQUIRED)
public interface UserDAO {  
    
    public User getUser(String login);  
  
}  