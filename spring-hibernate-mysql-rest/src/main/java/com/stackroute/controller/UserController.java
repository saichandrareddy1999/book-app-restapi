package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.stackroute.model.User;
import com.stackroute.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUserHandler() {
		System.out.println("Get All movie handler invoked");
		
		List<User> userList = userService.getAllUsers();
		
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> addNewUserHandler(@RequestBody User user) {
		System.out.println(" Add movie handler invoked");
		
		ResponseEntity<?> respEntity;
		
		try {
			User newUser = userService.addNewUser(user);
			respEntity =  new ResponseEntity<User>(newUser,HttpStatus.CREATED);
		} catch(Exception ex) {
			respEntity =  new ResponseEntity<String>("Failed to add",HttpStatus.CONFLICT);
		}
		return respEntity;	
		
	}	

}
