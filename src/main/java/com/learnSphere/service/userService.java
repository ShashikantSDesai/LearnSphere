package com.learnSphere.service;

import com.learnSphere.entity.Users;

public interface userService {
	//adds new user to database
	String addUser(Users user);
	//checks email is already exist present in database or not
	boolean checkEmail(String email);
	//validates user's credentials
	boolean validate(String email, String password);
	
	//get user's role by providing email
	String getUserRole(String email);
}
