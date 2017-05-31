package com.ultra.spring.annotation.repository.impl;

import org.springframework.stereotype.Repository;

import com.ultra.spring.annotation.repository.UserRepository;

@Repository
public class UserRepositoryImpl<T> implements UserRepository<T> {

	@Override
	public void add(T t) {
		System.out.println("UserRepositoryImpl add ..." + t);
	}

}
