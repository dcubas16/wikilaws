package org.wikilaws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wikilaws.dao.UserDAO;
import org.wikilaws.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired  
    private UserDAO userDAO;  
  
    public User getUser(String login) {  
        return userDAO.getUser(login);  
    }  

}
