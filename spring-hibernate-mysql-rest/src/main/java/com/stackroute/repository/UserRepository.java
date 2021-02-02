package com.stackroute.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.stackroute.model.User;



@Repository
@Transactional
public class UserRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(){
		
		return getSession().createQuery("from User").list();
	}
	
	public User findById(String id) {
		
		User user = getSession().find(User.class, id);
		return user;
	}
	
//public Country findById(String id) {
//		
//		Country movie = getSession().find(Country.class, id);
//		return movie;
//	}
	
	public Boolean addNew(User user) {


		if(findById(user.getEmail()) == null) {
			getSession().save(user);
			return true;
		}

		return false;

	}

}
