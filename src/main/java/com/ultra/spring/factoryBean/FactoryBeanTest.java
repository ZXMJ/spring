package com.ultra.spring.factoryBean;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;

public class FactoryBeanTest extends BeanTest {

	private Car car;

	@Before
	public void init() {
		super.init("beans-factoryBean.xml");
	}

	@Test
	public void testFactoryBean() {
		car = (Car) context.getBean("car");
		System.out.println(car);
	}
}
