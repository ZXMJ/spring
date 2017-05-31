package com.ultra.spring.transaction.xml.service.impl;

import java.util.List;

import com.ultra.spring.transaction.xml.dao.BookDao;
import com.ultra.spring.transaction.xml.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	private BookService bookService;

	@Override
	public void buy(int userId, int bookId) {
		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// }
		int price = bookDao.getPriceById(bookId);
		bookDao.updateStockByBookId(bookId);
		bookDao.updateBalanceByUserId(userId, price);
	}

	@Override
	public void buy(int userId, List<Integer> bookIds) {
		for (int bookId : bookIds) {
			bookService.buy(userId, bookId);
		}
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
