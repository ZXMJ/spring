package com.ultra.spring.aop.xml;

import org.aspectj.lang.JoinPoint;

public class ValidationAspect {

	public void validation(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " validation...");
	}
}
