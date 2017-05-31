package com.ultra.spring.bean;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;
import com.ultra.spring.spEL.Car;

public class BeanBasicTest extends BeanTest {

	private Car car;
	private Person person;

	@Before
	public void init() {
		super.init("application.xml");
	}

	/**
	 * @Description: 引用外部配置文件参数
	 *
	 * @date 2017年5月15日,下午3:28:12
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testPropertyPlaceholder() {
		car = (Car) context.getBean("car10");
		System.out.println(car);
	}

	/**
	 * @Description: scope:singleton:单例(加载配置文件时创建对象),prototype:非单例(获取对象时创建对象)
	 *
	 * @date 2017年5月15日,下午3:19:57
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testScope() {
		System.out.println("-----------------");
		car = (Car) context.getBean("car9");
		System.out.println(car);

		car = (Car) context.getBean("car9");
		System.out.println(car);
	}

	/**
	 * @Description: 自动装配对象(除String类型)和集合属性.
	 *
	 * @date 2017年5月15日,下午2:54:40
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testAutowire() {
		person = (Person) context.getBean("person10");
		System.out.println(person);
	}

	/**
	 * @Description: 依赖关系
	 *
	 * @date 2017年5月15日,下午4:04:34
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testDependson() {
		person = (Person) context.getBean("person11");
		System.out.println(person);

	}

	/**
	 * @Description: 继承父bean
	 *
	 * @date 2017年5月15日,下午2:45:44
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testParent() {
		car = (Car) context.getBean("car7");
		System.out.println(car);

		car = (Car) context.getBean("car8");
		System.out.println(car);
	}

	/**
	 * @Description: 通过property标签或者constructor-arg标签给list类型属性赋值.
	 *
	 * @date 2017年5月15日,下午1:43:45
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testPropertyList() {
		person = (Person) context.getBean("person7");
		System.out.println(person);

		person = (Person) context.getBean("person8");
		System.out.println(person);

		person = (Person) context.getBean("person9");
		System.out.println(person);
	}

	/**
	 * @Description: 级联属性赋值.
	 *
	 * @date 2017年5月15日,下午1:27:19
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testCascadeProperty() {
		person = (Person) context.getBean("person6");
		System.out.println(person);
	}

	/**
	 * @Description: 通过p:属性给对象属性赋值.
	 *
	 * @date 2017年5月15日,下午12:38:24
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testP() {
		person = (Person) context.getBean("person5");
		System.out.println(person);
	}

	/**
	 * @Description: 通过constructor-arg标签给对象一般属性赋值.
	 *
	 * @date 2017年5月15日,下午12:39:32
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testConstructorObject() {
		person = (Person) context.getBean("person3");
		System.out.println(person);

		person = (Person) context.getBean("person4");
		System.out.println(person);
	}

	/**
	 * @Description: 通过property标签给对象对象属性赋值.
	 *
	 * @date 2017年5月15日,下午12:38:24
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testPropertyObject() {
		person = (Person) context.getBean("person");
		System.out.println(person);

		person = (Person) context.getBean("person2");
		System.out.println(person);
	}

	/**
	 * @Description: 通过constructor-arg标签给对象简单属性赋值.
	 *
	 * @date 2017年5月15日,下午12:39:32
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testConstructor() {
		car = (Car) context.getBean("car2");
		System.out.println(car);

		car = (Car) context.getBean("car3");
		System.out.println(car);

		car = (Car) context.getBean("car4");
		System.out.println(car);

		car = (Car) context.getBean("car5");
		System.out.println(car);

		car = (Car) context.getBean("car6");
		System.out.println(car);
	}

	/**
	 * @Description: 通过property标签给对象简单属性赋值.
	 *
	 * @date 2017年5月15日,下午12:38:24
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testProperty() {
		car = (Car) context.getBean("car");
		System.out.println(car);
		// 某一个类只有一个对象(一个bean的配置)时,可以使用通过class的类型获取.
		// car = (Car) context.getBean(Car.class);
		// System.out.println(car);
	}
}
