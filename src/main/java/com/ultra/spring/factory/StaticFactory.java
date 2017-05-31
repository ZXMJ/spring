package com.ultra.spring.factory;

public class StaticFactory {

	public static Car getInstance(String name,double price){
		return new Car(name,price);
	}
}
