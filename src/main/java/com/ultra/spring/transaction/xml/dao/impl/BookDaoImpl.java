package com.ultra.spring.transaction.xml.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ultra.spring.transaction.xml.dao.BookDao;
import com.ultra.spring.transaction.xml.exception.BookException;
import com.ultra.spring.transaction.xml.exception.UserException;

public class BookDaoImpl implements BookDao {

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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
