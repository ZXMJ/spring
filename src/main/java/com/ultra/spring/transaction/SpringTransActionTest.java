package com.ultra.spring.transaction;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;
import com.ultra.spring.transaction.dao.BookDao;
import com.ultra.spring.transaction.service.BookManager;
import com.ultra.spring.transaction.service.BookService;

public class SpringTransActionTest extends BeanTest {

	private BookDao bookDao;
	private BookService bookService;
	private BookManager bookManager;

	@Before
	public void init() {
		super.init("application-transaction.xml");
		bookDao = (BookDao) context.getBean("bookDao");
		bookService = (BookService) context.getBean("bookService");
		bookManager = context.getBean(BookManager.class);
	}

	/**
	 * propagation:事务的传播行为,REQUIRED:使用已存在的事务,REQUIRES_NEW:创建新事务.
	 * PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。
	 * PROPAGATION_SUPPORTS--支持当前事务，如果当前没有事务，就以非事务方式执行。
	 * PROPAGATION_MANDATORY--支持当前事务，如果当前没有事务，就抛出异常。
	 * PROPAGATION_REQUIRES_NEW--新建事务，如果当前存在事务，把当前事务挂起。
	 * PROPAGATION_NOT_SUPPORTED--以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
	 * PROPAGATION_NEVER--以非事务方式执行，如果当前存在事务，则抛出异常。
	 * 
	 * isolation:事务隔离级别.Read_uncommitted(会出现脏读的情况),Read_committed(不可重复读:
	 * 一个事务范围内两个相同的查询却返回了不同数据,不可重复读对应的是修改，即UPDATE操作),Repeatable_read(
	 * 幻读问题对应的是插入INSERT操作，而不是UPDATE操作),
	 * Serializable:是最高的事务隔离级别，在该级别下，事务串行化顺序执行，可以避免脏读、不可重复读与幻读。但是这种事务隔离级别效率低下，
	 * 比较耗数据库性能，一般不使用。
	 * 
	 * readOnly:只读事务.只有查询操作时,设置readOnly=true事务,利于系统性能的提高.
	 * 
	 * timeout:该事务占有资源的最大时间,超时后会抛异常,事务回滚.
	 * 
	 * rollbackFor:只回滚该异常的事务. noRollbackFor:不回滚该异常的事务.
	 * eg:rollbackFor=UserException.class
	 * 
	 * @date 2017年5月19日,上午11:05:31
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.ultra.spring.transaction.service.BookService#buy(int, int)
	 */

	/**
	 * @Description: 测试bookManager,事务的传播行为.
	 *
	 * @date 2017年5月19日,下午1:07:40
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testBookManager() {
		List<Integer> bookIds = Arrays.asList(1, 2);
		bookManager.buy(1, bookIds);
	}

	/**
	 * @Description: 测试bookService,事务的传播行为.
	 *
	 * @date 2017年5月19日,上午11:00:57
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testBookService2() {
		List<Integer> bookIds = Arrays.asList(1, 2);
		bookService.buy(1, bookIds);
	}

	/**
	 * @Description: 测试bookService,有事务.
	 *
	 * @date 2017年5月19日,上午11:00:57
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testBookService() {
		bookService.buy(1, 1);
	}

	/**
	 * @Description: 测试bookDao,无事务.
	 *
	 * @date 2017年5月19日,上午11:00:30
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testBookDao() {
		int price = bookDao.getPriceById(1);
		bookDao.updateStockByBookId(1);
		bookDao.updateBalanceByUserId(1, price);
		System.out.println(price);
	}
}
