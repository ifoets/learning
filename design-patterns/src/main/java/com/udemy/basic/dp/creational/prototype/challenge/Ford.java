package com.udemy.basic.dp.creational.prototype.challenge;

public class Ford extends BasicCar {

	Ford() {
		price = 30.5;
	}

	@Override
	public void show() {
		System.out.println("Car is: " + model + " Price of car is: " + price + "lac");
	}

}
