package com.stackroute.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.stackroute.config.MovieWebAppContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MovieWebAppContext.class})
@WebAppConfiguration
public class UserServiceIntegrationTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getAllUserShouldReturnAllUsers() {
		System.out.println(userService.getAllUsers());
	}

}
