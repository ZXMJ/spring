package com.ultra.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ultra.spring.annotation.bean.User;
import com.ultra.spring.annotation.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService<User> userService;

	public void addUser() {
		System.out.println("UserController addUser ... ");
		userService.save(new User());
	}
}
