package com.service.impl;

import org.springframework.stereotype.Service;

import com.pojo.Users;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void showUser(Users user) {
		System.out.println(user);
	}

}
