package com.udemy.basic.dp.structural.decorator.challenge;

public abstract class ShapeDecorator implements IDecoShape {
	IDecoShape shape;

	public ShapeDecorator(IDecoShape shape) {
		this.shape = shape;
	}

	public void draw() {
		shape.draw();
	}
}
