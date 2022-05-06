package com.udemy.basic.dp.creational.prototype.challenge;

public abstract class BasicCar implements Cloneable {

	public String model;
	public double price;

	abstract void show();

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return clone;
	}
}
