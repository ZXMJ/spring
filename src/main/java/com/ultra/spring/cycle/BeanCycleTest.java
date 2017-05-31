package com.ultra.spring.cycle;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ultra.spring.BeanTest;

public class BeanCycleTest extends BeanTest {
	private Car car;

	@Before
	public void init() {
		super.init("beans-cycle.xml");
	}

	/**
	 * @Description: 未配置BeanPostProcessor的实现类,bean的生命周期:启动IOC容器时创建对象,赋值属性,
	 *               调用对象初始化方法,关闭IOC时,调用对象的销毁方法.配置BeanPostProcessor的实现类,
	 *               bean的生命周期:启动IOC容器时创建对象,属性赋值,
	 *               调用BeanPostProcessor的实现类的postProcessBeforeInitialization方法,
	 *               调用对象的初始化方法,
	 *               调用BeanPostProcessor的实现类的postProcessAfterInitializatio方法,
	 *               关闭IOC容器时,调用对象的销毁方法.
	 *
	 * @date 2017年5月16日,下午5:41:34
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testCycle() {
		car = (Car) context.getBean("car");
		System.out.println(car);

		((ClassPathXmlApplicationContext) context).close();
	}
}
