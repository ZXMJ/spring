package com.ultra.spring.cycle;

public class Car {

	private String name;

	public Car() {
		System.out.println("Car Constructor ...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Car setter ...");
	}

	public void init() {
		System.out.println("Car init ...");
	}

	public void destory() {
		System.out.println("Car destory ...");
	}
}
