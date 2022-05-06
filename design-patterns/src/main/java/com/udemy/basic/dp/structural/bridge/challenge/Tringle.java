package com.udemy.basic.dp.structural.bridge.challenge;

public class Tringle extends Shape {
	public int border;

	public Tringle(IColor color) {
		super(color);
	}

	@Override
	public void drawShapes(int border) {
		this.border = border;
		System.out.println("\nColoring Tringle: ");
		System.out
		        .println("This Tringle is Colored with: " + color.fillWithColor() + " with " + border + " inch border");
	}

	@Override
	public void modifyBorder(int border, int increment) {
		System.out.println("\nNow We are changing the border length " + increment + " times");
		drawShapes(border * increment);
	}
}
