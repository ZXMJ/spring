package com.ultra.spring.aop.xml;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;

public class ProxyTest extends BeanTest {

	@Before
	public void init() {
		super.init("beans-aop-xml.xml");
	}

	@Test
	public void testProxy() {
		Calculator calculator = (Calculator) context.getBean("calculatorImpl");
		System.out.println(calculator.add(6, 4));
		System.out.println(calculator.div(10, 2));
		// System.out.println(calculator.div(10, 0));

	}
}
