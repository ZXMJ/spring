package com.ultra.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
	
	protected ApplicationContext context = null;

	protected void init(String configName) {
		context = new ClassPathXmlApplicationContext(configName);
	}

}
