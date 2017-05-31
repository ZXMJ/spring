package com.ultra.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面Bean的优先级,越小优先级越高
@Order(2)
// 声明这是一个切面bean
@Aspect
@Component
public class LoggingAspect {

	// 设置切入点,该方法无方法体
	@Pointcut("execution(* com.ultra.spring.aop.*.*(int,int))")
	public void pointCut() {
	}

	// 设置切入点
	@Pointcut("execution(* com.ultra.spring.aop.*.*(..))")
	public void pointCut2() {
	}

	// 前置通知,使用在方法pointCut2()上注册的切入点
	@Before("pointCut2()")
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " before" + Arrays.asList(joinPoint.getArgs()));
	}

	// 后置通知:方法执行后,无论是否抛异常.
	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " end");
	}

	// 返回通知,方法正常结束时,返回通知,可以获取返回值.
	@AfterReturning(pointcut = "pointCut()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName() + " end with" + result);
	}

	// 异常通知,执行方法抛出异常时,执行异常通知,可以获取到异常信息.
	@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println(joinPoint.getSignature().getName() + " exception with" + ex);
	}

	// 环绕通知,需要ProceedingJoinPoint参数类型的参数,需要有一个返回值.
	// @Around("pointCut()")
	// public Object around(ProceedingJoinPoint joinPoint) {
	// Object result = null;
	// try {
	// // 前置通知
	// before(joinPoint);
	// // 执行方法
	// result = joinPoint.proceed(joinPoint.getArgs());
	// // 返回通知
	// afterReturning(joinPoint, result);
	// } catch (Throwable e) {
	// // 异常通知
	// afterThrowing(joinPoint, e);
	// e.printStackTrace();
	// }
	// // 后置通知
	// after(joinPoint);
	// return result;
	// }
}
