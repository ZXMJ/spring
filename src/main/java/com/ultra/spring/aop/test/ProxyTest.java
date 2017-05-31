package com.ultra.spring.aop.test;

import org.junit.Test;

import com.ultra.spring.aop.Calculator;
import com.ultra.spring.aop.CalculatorImpl;

public class ProxyTest {

	@Test
	public void testProxy() {
		ProxyCalculator<Calculator> proxy = new ProxyCalculator<Calculator>(new CalculatorImpl());
		System.out.println(proxy.getLoggingProxy().add(3, 6));
	}
}
