package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.LoginUser;
import com.stackroute.service.AuthenticationService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	
	String logedInEmail = null;
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginHandler(@RequestBody LoginUser user){
		System.out.println("login handler called");
		ResponseEntity<?> responseEntity;
		if(authService.authenticate(user.getEmail(), user.getPassword())) {
			logedInEmail = user.getEmail();
			responseEntity = new ResponseEntity<String>("User Logged In", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("Login failed", HttpStatus.FORBIDDEN);
		}
		return responseEntity;
	}
	
	@GetMapping(value = "/logout")
	public ResponseEntity<?> logoutHandler(){
		System.out.println("logout handler called");
		ResponseEntity<?> responseEntity;
		if( logedInEmail != null) {
			logedInEmail = null;
			responseEntity = new ResponseEntity<String>("User logged out", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("No User Logged-in", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;

	}
}
