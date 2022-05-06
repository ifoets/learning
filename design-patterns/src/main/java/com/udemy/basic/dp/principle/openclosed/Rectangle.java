package com.udemy.basic.dp.principle.openclosed;

public class Rectangle implements Shape {

	private int length;
	private int width;

	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	public double calculateArea() {
		return length * width;
	}

}
