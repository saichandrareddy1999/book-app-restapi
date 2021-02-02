package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stackroute.exception.UserAlreadyExistException;
import com.stackroute.exception.UserNotFoundException;

import com.stackroute.model.User;
import com.stackroute.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRespository;
	
	public List<User> getAllUsers(){
		return userRespository.findAllUsers();
	}
	
	public User addNewUser(User user) throws UserAlreadyExistException {

		Boolean status = userRespository.addNew(user);
		if(status) {
			return user;
		}
		throw new UserAlreadyExistException();
	}
	
	public User getCMatchById(String id) throws UserNotFoundException {

		User user = userRespository.findById(id);
		if(user != null) {
			return user;
		}

		throw new UserNotFoundException();
	}

}
