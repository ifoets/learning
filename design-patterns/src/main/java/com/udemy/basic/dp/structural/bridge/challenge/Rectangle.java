package com.udemy.basic.dp.structural.bridge.challenge;

public class Rectangle extends Shape {
	public int border;

	public Rectangle(IColor color) {
		super(color);
	}

	@Override
	public void drawShapes(int border) {
		this.border = border;
		System.out.println("\nColoring Rectangle: ");
		System.out.println(
		        "This Rectangle is Colored with: " + color.fillWithColor() + " with " + border + " inch border");
	}

	@Override
	public void modifyBorder(int border, int increment) {
		System.out.println("\nNow We are changing the border length " + increment + " times");
		drawShapes(border * increment);
	}
}
