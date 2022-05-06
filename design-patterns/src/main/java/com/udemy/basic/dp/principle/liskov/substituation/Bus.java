package com.udemy.basic.dp.principle.liskov.substituation;

public class Bus extends Vehicle {

	@Override
	public int getSpeed() {
		System.out.println("Speed from Bus get Called");
		return 0;
	}

	@Override
	public int getCubicCapicity() {
		System.out.println("Capaity from Bus get Called");
		return 0;
	}

	String getEmergencyExitLoc() {
		return null;
	}
}
