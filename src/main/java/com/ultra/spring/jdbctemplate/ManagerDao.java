package com.ultra.spring.jdbctemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDao extends JdbcDaoSupport {

	/**
	 * @Description: 在方法上使用注解.不能重写父类的final方法时,可以改个名字调用父类的方法.
	 *
	 * @date 2017年5月18日,下午4:10:47
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param dataSource
	 */
	@Autowired
	public final void setDataSource2(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public Manager get(Integer id) {
		String sql = "SELECT MANAGER_ID id,MANAGER_NAME name FROM MANAGER WHERE MANAGER_ID = ?";
		RowMapper<Manager> rowMapper = new BeanPropertyRowMapper<>(Manager.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}
}
