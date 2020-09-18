package com.service;

import com.pojo.Users;

public interface UserService {
	
	void addUser(Users users);
	
	Users findUserById(int userid);
	
	void updateUser(Users users);
}
