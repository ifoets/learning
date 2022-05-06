package com.udemy.basic.dp.creational.prototype;

public class PSquare extends PShape {

	public PSquare() {
		type = "Square";
	}

	@Override
	void draw() {
		System.out.println("Inside Square :draw() method");

	}

}
