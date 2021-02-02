package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	private String fName;
	private String lName;
	
	@Id
	@Column(length = 64)
	private String email;
	private String password;
	
	
	public User() {
		
	}

	
	

	public User(String fName, String lName, String email, String password) {
		
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}




	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
