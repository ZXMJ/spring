package com.ultra.spring.annotation.service;

import com.ultra.spring.annotation.repository.UserRepository;

public interface UserService<User> extends UserRepository<User> {
	public void save(User user);
}
