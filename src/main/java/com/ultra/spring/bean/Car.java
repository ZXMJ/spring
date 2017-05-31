package com.ultra.spring.bean;

public class Car {

	private String name;
	private String desc;
	private int maxSpeed;
	private double price;

	public Car() {
		System.out.println("Car sonstructor...");
	}

	public Car(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Car(String name, int maxSpeed) {
		super();
		this.name = name;
		this.maxSpeed = maxSpeed;
	}

	public Car(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public Car(String name, int maxSpeed, double price) {
		super();
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", desc=" + desc + ", maxSpeed=" + maxSpeed + ", price=" + price + "]";
	}

}
