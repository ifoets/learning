package com.udemy.basic.dp.principle.liskov.substituation;

public class Car extends Vehicle {

	@Override
	public int getSpeed() {
		System.out.println("Speed from Car get Called");
		return 0;
	}

	@Override
	public int getCubicCapicity() {
		System.out.println("Capaity from Car get Called");
		return 0;
	}

	boolean sHatchBack() {
		return false;
	}

}
