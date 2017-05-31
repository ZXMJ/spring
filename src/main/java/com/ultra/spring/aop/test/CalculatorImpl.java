package com.ultra.spring.aop.test;

public class CalculatorImpl implements Calculator {

	public int add(int i, int j) {
		System.out.println("add ...");
		int result = i + j;
		return result;
	}

	public int sub(int i, int j) {
		System.out.println("sub ...");
		int result = i - j;
		return result;
	}

	public int mul(int i, int j) {
		System.out.println("mul ...");
		int result = i * j;
		return result;
	}

	public int div(int i, int j) {
		System.out.println("div ...");
		int result = i / j;
		return result;
	}
}
