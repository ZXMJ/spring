package com.ultra.spring.factory;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;

public class BeanFactoryTest extends BeanTest {
	private Car car;

	@Before
	public void init() {
		super.init("beans-factory.xml");
	}

	@Test
	public void testInstanceFactory() {
		car = (Car) context.getBean("car2");
		System.out.println(car);
	}

	/**
	 * @Description:
	 *
	 * @date 2017年5月16日,下午5:41:34
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testStaticFactory() {
		car = (Car) context.getBean("car");
		System.out.println(car);
	}
}
