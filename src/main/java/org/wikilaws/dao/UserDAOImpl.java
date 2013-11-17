package org.wikilaws.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wikilaws.entities.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {  
      
    public User getUser(String login) {  
    	Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = (User) session.createQuery("from User u where u.login = "+login);
		session.close();
		return user;
 
    }  
  
}  
