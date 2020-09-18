package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Users;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 添加用户
	 */
	@RequestMapping("/addUser")
	public String addUser(Users user){
		this.userService.addUser(user);
		return "ok";
	}
	
	/**
	 * 根据用户ID查询用户
	 */
	@RequestMapping("/findUserById")
	public String showUser(Model model,int userid){
		Users users = this.userService.findUserById(userid);
		model.addAttribute("users", users);
		return "showUser";
	}
	
	/**
	 * 更新用户
	 */
	@RequestMapping("/updateUser")
	public String updateUser(Users users){
		this.userService.updateUser(users);
		return "ok";
	}
}
