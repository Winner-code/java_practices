package com.mapper;

import java.util.List;

import com.pojo.Users;

public interface UserMapper {

	public void insertUser(Users user);
	
	public List<Users> selectUserAll();
	
	Users findUserById(int userid);
	
	void updateUser(Users users);
}
