package com.stackroute.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.model.User;
import com.stackroute.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	private static User user;
	private static List<User> userList;
	private static User[] users;
	
	static {
		user = new User("hari","krishna","hari@gmail.com","12345");
		users = new User[] {
				new User("mohan","krishna","mohan@gmail.com","12345"),
				new User("vinay","krishna","krishna@gmail.com","12345")
			};
		userList = Arrays.asList(users);
	}
	
	@Test
	public void givenGetRequestToUserEndpointShouldReturnAllUsers() throws Exception {
		
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		when(userService.getAllUsers()).thenReturn(userList);
		mockMvc.perform(get("/api/v1/user")).andDo(print());
	}

}
