package com.ultra.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//切面Bean的优先级,越小优先级越高
@Order(1)
@Aspect
@Component
public class ValidationAspect {

	// 引用其他类的切入点
	// @Before("com.ultra.spring.aop.LoggingAspect.pointCut2()")
	@Before("LoggingAspect.pointCut2()")
	public void validation(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " validation...");
	}
}
