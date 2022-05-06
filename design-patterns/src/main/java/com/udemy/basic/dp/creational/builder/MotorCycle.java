package com.udemy.basic.dp.creational.builder;

public class MotorCycle implements IVehicleBuilder {

	private Product product = new Product();

	@Override
	public void buildBody() {
		product.add("This is Body of MotorCycle");
	}

	@Override
	public void addHeadlights() {
		product.add("1 Headlights are added");
	}

	@Override
	public void insertWheels() {
		product.add("2 Wheels are addes");
	}

	@Override
	public Product getVehicle() {
		return product;
	}
}