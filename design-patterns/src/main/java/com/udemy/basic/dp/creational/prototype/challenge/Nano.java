package com.udemy.basic.dp.creational.prototype.challenge;

public class Nano extends BasicCar {

	Nano() {
		price = 1.2;
	}

	@Override
	public void show() {
		System.out.println("Car is: " + model + " Price of car is: " + price + "lac");
	}

}
