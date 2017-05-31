package com.ultra.spring.transaction.xml.service.impl;

import java.util.List;

import com.ultra.spring.transaction.xml.service.BookManager;
import com.ultra.spring.transaction.xml.service.BookService;


public class BookManagerImpl implements BookManager {

	private BookService bookService;

	@Override
	public void buy(int userId, List<Integer> bookIds) {
		for (int bookId : bookIds) {
			bookService.buy(userId, bookId);
		}
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
