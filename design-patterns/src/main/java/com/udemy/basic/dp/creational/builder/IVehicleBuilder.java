package com.udemy.basic.dp.creational.builder;

public interface IVehicleBuilder {

	public void buildBody();

	public void addHeadlights();

	public void insertWheels();

	public Product getVehicle();
}
