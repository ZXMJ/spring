package com.ultra.spring.factory;

public class InstanceFactory {

	public Car getInstance(String name,double price) {
		return new Car(name, price);
	}

}
