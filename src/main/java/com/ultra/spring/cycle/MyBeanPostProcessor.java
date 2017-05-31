package com.ultra.spring.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	private String prefix;

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor postProcessBeforeInitialization:" + bean + " :" + prefix + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor postProcessAfterInitialization:" + bean + " :" + prefix + beanName);
		return bean;
	}

}
