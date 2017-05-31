package com.ultra.spring.annotation.service.impl;

import org.springframework.stereotype.Service;

import com.ultra.spring.annotation.bean.User;
import com.ultra.spring.annotation.repository.impl.UserRepositoryImpl;
import com.ultra.spring.annotation.service.UserService;

@Service
public class UserServiceImpl extends UserRepositoryImpl<User> implements UserService<User> {

	@Override
	public void save(User user) {
		System.out.println("UserServiceImpl save ... " + user);
		add(user);
	}
}
