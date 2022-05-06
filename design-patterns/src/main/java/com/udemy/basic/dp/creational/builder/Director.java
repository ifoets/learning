package com.udemy.basic.dp.creational.builder;

public class Director {

	IVehicleBuilder vehicleBuilder;

	public void construct(IVehicleBuilder builder) {
		vehicleBuilder = builder;
		
		vehicleBuilder.buildBody();
		vehicleBuilder.addHeadlights();
		vehicleBuilder.insertWheels();
	}
}
