package com.ultra.spring.jdbctemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JdbcTemplateTest {

	private ApplicationContext context;
	private JdbcTemplate jdbcTemplate;
	private ManagerDao managerDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("application-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		managerDao = context.getBean(ManagerDao.class);
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");
	}

	/**
	 * @Description: sql的占位符使用:name,填充时使用对象填充占位符. 1. SQL 语句中的参数名和类的属性一致! 2. 使用
	 *               SqlParameterSource 的 BeanPropertySqlParameterSource
	 *               实现类作为参数.
	 * @date 2017年5月18日,下午4:35:27
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testNamedParameterJdbcTemplateObject() {
		String sql = "INSERT INTO EMP (EMP_NAME,MANAGER_ID) VALUES (:name, :manager.id)";
		Emp emp = new Emp();
		emp.setName("emp-ee");
		Manager manager = new Manager();
		manager.setId(1);
		emp.setManager(manager);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(emp);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * @Description: sql的占位符使用:name,填充时参数使用map(key:占位符的名称,value:填充的值)
	 *
	 * @date 2017年5月18日,下午4:33:49
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "INSERT INTO EMP (EMP_NAME,MANAGER_ID) VALUES (:name, :id)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", "emp--ff");
		paramMap.put("id", 2);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}

	/**
	 * @Description: dao接口继承JdbcDaoSupport的方式获取jdbcTemplate.
	 *
	 * @date 2017年5月18日,下午4:10:31
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testJdbcDaoSupport() {
		System.out.println(managerDao.get(1));
	}

	/**
	 * @Description: 获取的某一列或者统计函数,结果只有一列.
	 *
	 * @date 2017年5月18日,下午3:15:09
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testQueryForSingle() {
		String sql = "SELECT COUNT(EMP_ID) FROM EMP WHERE EMP_ID > ?";
		System.out.println(jdbcTemplate.queryForObject(sql, Long.class, 1));
	}

	/**
	 * @Description: 注意查询对象的集合调用的不是 queryForList 方法
	 *
	 * @date 2017年5月18日,下午3:00:42
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testQueryForList() {
		String sql = "SELECT EMP_ID id,EMP_NAME name,MANAGER_ID AS 'manager.id' FROM EMP WHERE EMP_ID > ?";
		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<Emp>(Emp.class);
		System.out.println(jdbcTemplate.query(sql, rowMapper, 1));
	}

	/**
	 * @Description: 查询单个对象,使用queryForObject(String sql, RowMapper
	 *               <Emp> rowMapper, Object... args)
	 *               RowMapper:实现了RowMapper接口的BeanPropertyRowMapper对象
	 *               不能通过外键关系赋值对象,即不能级联查询. MANAGER_ID AS 'manager.id':不起作用.
	 *
	 * @date 2017年5月18日,下午2:53:41
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void queryForObject() {
		String sql = "SELECT EMP_ID id,EMP_NAME name,MANAGER_ID AS 'manager.id' FROM EMP WHERE EMP_ID = ?";
		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<Emp>(Emp.class);
		System.out.println(jdbcTemplate.queryForObject(sql, rowMapper, 1));
	}

	/**
	 * @Description: 批量更新:批量 INSERT,DELETE,UPDATE.
	 *
	 * @date 2017年5月18日,下午2:45:06
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void batchUpdate() {
		String sql = "UPDATE EMP SET EMP_NAME = ? WHERE EMP_ID = ?";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] { "emp--bb", 2 });
		batchArgs.add(new Object[] { "emp--cc", 3 });
		batchArgs.add(new Object[] { "emp--dd", 4 });
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	/**
	 * @Description: update:INSERT, DELETE, UPDATE
	 *
	 * @date 2017年5月18日,下午2:22:28
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testUpdate() {
		String sql = "UPDATE EMP SET EMP_NAME = ? WHERE EMP_ID = ?";
		jdbcTemplate.update(sql, "emp--aa", 1);
	}
}
