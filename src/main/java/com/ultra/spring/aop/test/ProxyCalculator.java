package com.ultra.spring.aop.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.ultra.spring.aop.Calculator;

public class ProxyCalculator<T> {
	// 被代理的对象
	private T t;

	public ProxyCalculator(T t) {
		super();
		this.t = t;
	}

	// 添加通知,并返回代理对象
	public Calculator getLoggingProxy() {
		Calculator cal;
		ClassLoader loader = t.getClass().getClassLoader();
		Class<?>[] interfaces = t.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				Object result = null;
				//
				try {
					// 前置通知
					System.out.println(methodName + " before ... ");
					result = method.invoke(t, args);
					// 返回通知
					System.out.println(methodName + " end with ... " + result);
				} catch (Exception e) {
					// 异常通知
					System.out.println(methodName + " exception ... " + e);
					e.printStackTrace();
				}
				// 后置通知
				System.out.println(methodName + " end ");
				return result;
			}
		};
		cal = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);
		return cal;
	}

}
