package com.udemy.basic.dp.creational.builder;

public class Car implements IVehicleBuilder {

	private Product product = new Product();

	@Override
	public void buildBody() {
		product.add("This is Body of Car");
	}

	@Override
	public void addHeadlights() {
		product.add("2 Headlights are added");
	}

	@Override
	public void insertWheels() {
		product.add("4 Wheels are addes");
	}

	@Override
	public Product getVehicle() {
		return product;
	}
}