package com.stackroute.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stackroute.model.User;

@ExtendWith(MockitoExtension.class)
public class UserRespositoryTest {
	
	@InjectMocks
	private UserRepository userRepo;

	@Mock
	private SessionFactory sessionFactory;

	@Mock
	private Session session;
	
	@Mock
	private Query<User> query;
	
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
	
	@BeforeEach
	public void setup() {
		
		when(sessionFactory.getCurrentSession()).thenReturn(session);
	}
	
	@Test
	public void getSessionShouldReturnCurrentSessionObject() {
		
		assertEquals(userRepo.getSession(), session);
		verify(sessionFactory,times(1)).getCurrentSession();
	}

	@Test
	public void givenValidUserIdThenFindByIdShouldInvokeFind() {

		when(session.find(any(), any())).thenReturn(user);

		assertThat(userRepo.findById("hari@gmail.com"), is((user)));
		verify(session, times(1)).find(any(), any());
	}
	
	@Test
	public void findAllshouldReturnAllUsers() {
		
		when(session.createQuery("from User")).thenReturn(query);
		when(query.list()).thenReturn(userList);
		List<User> actual = userRepo.findAllUsers();
		assertThat(actual, hasSize(2));
		assertThat(actual, hasItems(users[0],users[1]));
		verify(sessionFactory,times(1)).getCurrentSession();
		verify(session,times(1)).createQuery("from User");
		verify(query,times(1)).list();
	}

}
