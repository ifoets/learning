package com.udemy.basic.dp.principle.openclosed;

public class Circle implements Shape {

	private int radius;

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	public double calculateArea() {
		return (22 / 7) * radius * radius;
	}
}
