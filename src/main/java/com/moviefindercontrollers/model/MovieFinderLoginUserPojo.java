package com.moviefindercontrollers.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class MovieFinderLoginUserPojo {

	@NotEmpty(message = "Email is Required")
	@Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" , message = "Please Give The Valid Email Id")
	
	private String email;
	
	@NotEmpty(message = "Password is Required")
	private String password;

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
