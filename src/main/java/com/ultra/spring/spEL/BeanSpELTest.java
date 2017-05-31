package com.ultra.spring.spEL;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;

public class BeanSpELTest extends BeanTest {
	private Car car;
	private Person person;

	@Before
	public void init() {
		super.init("beans-spEL.xml");
	}

	@Test
	public void testSpEL() {
		car = (Car) context.getBean("car");
		System.out.println(car);
//		你好
		person = (Person) context.getBean("person");
		System.out.println(person);
	}
}
