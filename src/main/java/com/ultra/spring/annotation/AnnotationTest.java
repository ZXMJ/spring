package com.ultra.spring.annotation;

import org.junit.Before;
import org.junit.Test;

import com.ultra.spring.BeanTest;
import com.ultra.spring.annotation.bean.User;
import com.ultra.spring.annotation.controller.UserController;
import com.ultra.spring.annotation.repository.UserRepository;
import com.ultra.spring.annotation.service.UserService;

public class AnnotationTest extends BeanTest {

	@Before
	public void init() {
		super.init("beans-annotation.xml");
	}

	/**
	 * @Description: 注入属性bean
	 *
	 * @date 2017年5月17日,下午2:43:06
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testPropertyAnnontation(){
		UserController userController = (UserController) context.getBean("userController");
		System.out.println(userController);
		userController.addUser();
	}
	
	/**
	 * @Description: 类注解有@Controller,@Component,@Service,@Repository
	 *
	 * @date 2017年5月17日,下午2:21:20
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testClassAnnotation() {

		UserController userController = (UserController) context.getBean("userController");
		System.out.println(userController);
		
		@SuppressWarnings("unchecked")
		UserService<User> userService = (UserService<User>) context.getBean("userServiceImpl");
		System.out.println(userService);

		@SuppressWarnings("unchecked")
		UserRepository<User> userRepository = (UserRepository<User>) context.getBean("userRepositoryImpl");
		System.out.println(userRepository);
	}
}
