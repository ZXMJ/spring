package com.ultra.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class Car implements FactoryBean<Car> {

	private String name;
	private double price;

	public Car() {
	}

	public Car(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public Car getObject() throws Exception {
		return new Car(name, price);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}

}
