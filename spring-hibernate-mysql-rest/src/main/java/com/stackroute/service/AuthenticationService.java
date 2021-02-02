package com.stackroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.model.User;
import com.stackroute.repository.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	UserRepository userRepository;
	public boolean authenticate(String email, String password) {
		boolean status = false;
		User user = userRepository.findById(email);
		if(user != null) {
			String userPassoword = user.getPassword();
			if(password.equals(userPassoword)) {
				status = true;
			}
		}
		return status;
	}
}
