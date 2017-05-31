package com.ultra.spring.bean;

import java.util.List;

public class Person {

	private String name;
	private Car car;
	private List<Car> cars;

	public Person() {
	}

	public Person(String name, Car car) {
		super();
		this.name = name;
		this.car = car;
	}

	public Person(String name, Car car, List<Car> cars) {
		super();
		this.name = name;
		this.car = car;
		this.cars = cars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", cars=" + cars + "]";
	}

}
