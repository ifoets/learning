package com.udemy.basic.dp.creational.prototype;

public class PRectangle extends PShape {

	public PRectangle() {
		type = "Rectangle";
	}

	@Override
	void draw() {
		System.out.println("Inside Rectangle :draw() method");

	}

}
