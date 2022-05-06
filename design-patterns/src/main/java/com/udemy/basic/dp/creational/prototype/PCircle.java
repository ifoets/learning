package com.udemy.basic.dp.creational.prototype;

public class PCircle extends PShape {

	public PCircle() {
		type = "Circle";
	}

	@Override
	void draw() {
		System.out.println("Inside Circle :draw() method");

	}

}
