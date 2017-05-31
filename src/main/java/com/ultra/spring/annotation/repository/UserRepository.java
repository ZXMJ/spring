package com.ultra.spring.annotation.repository;

public interface UserRepository<T> {
	void add(T t);
}
