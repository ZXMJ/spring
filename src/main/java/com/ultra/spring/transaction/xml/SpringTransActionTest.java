package com.ultra.spring.transaction.xml;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;
import com.ultra.spring.transaction.xml.dao.BookDao;
import com.ultra.spring.transaction.xml.service.BookManager;
import com.ultra.spring.transaction.xml.service.BookService;

public class SpringTransActionTest extends BeanTest {

	private BookDao bookDao;
	private BookService bookService;
	private BookManager bookManager;

	@Before
	public void init() {
		super.init("application-transaction-xml.xml");
		bookDao = context.getBean(BookDao.class);
		bookService = context.getBean(BookService.class);
		bookManager = context.getBean(BookManager.class);
	}

	@Test
	public void testBookManager() {
		List<Integer> bookIds = Arrays.asList(1, 2);
		bookManager.buy(1, bookIds);
	}

	@Test
	public void testBookService2() {
		List<Integer> bookIds = Arrays.asList(1, 2);
		bookService.buy(1, bookIds);
	}

	@Test
	public void testBookService() {
		bookService.buy(1, 1);
	}

	@Test
	public void testBookDao() {
		int price = bookDao.getPriceById(1);
		bookDao.updateStockByBookId(1);
		bookDao.updateBalanceByUserId(1, price);
		System.out.println(price);
	}
}
