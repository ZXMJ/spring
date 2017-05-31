package com.ultra.spring.transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ultra.spring.transaction.dao.BookDao;
import com.ultra.spring.transaction.exception.BookException;
import com.ultra.spring.transaction.exception.UserException;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPriceById(Integer bookId) {
		String sql = "SELECT PRICE FROM BOOK WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
	}

	@Override
	public void updateStockByBookId(Integer bookId) {
		String sql = "UPDATE BOOK SET STOCK = STOCK - 1 WHERE ID = ? AND STOCK > 0";
		int result = jdbcTemplate.update(sql, bookId);
		if (result > 0)
			return;
		else {
			throw new BookException("库存不足...");
		}
	}

	@Override
	public void updateBalanceByUserId(Integer userId, int price) {
		String sql = "UPDATE USER SET BALANCE = BALANCE - ? WHERE ID = ? AND BALANCE >= ?";
		int result = jdbcTemplate.update(sql, price, userId, price);
		if (result > 0)
			return;
		else {
			throw new UserException("余额不足...");
		}
	}

}
