package com.ultra.spring.transaction.service;

import java.util.List;

public interface BookService {

	public void buy(int userId, int bookId);

	public void buy(int userId, List<Integer> bookIds);
}
