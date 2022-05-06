package com.udemy.basic.dp.structural.bridge.challenge;

public abstract class Shape {
	protected IColor color;

	protected Shape(IColor color) {
		this.color = color;
	}

	public abstract void drawShapes(int border);

	public abstract void modifyBorder(int border, int increment);
}
