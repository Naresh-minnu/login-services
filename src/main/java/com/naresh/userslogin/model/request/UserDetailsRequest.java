package com.naresh.userslogin.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequest {

	@NotNull(message="First name can't be null")
	@Size(min=2, message="First name minimum 2 characters")
	private String firstName;
	
	@NotNull(message="Last name can't be null")
	@Size(min=2, message="Last name minimum 2 characters")
	private String lastName;
	
	@NotNull(message="Email can't be null")
	@Email
	private String email;
	
	@NotNull(message="Password can't be null")
	@Size(min=8, max=16, message="Paassword must be equal or greater than 8 characters and lesss than 16 characters")
	private String password;
	
		public UserDetailsRequest() {
		// TODO Auto-generated constructor stub
	}
		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
}
