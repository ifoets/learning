package com.udemy.basic.dp.structural.decorator.challenge;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(IDecoShape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		super.draw();
		setGreenBorder();
	}

	private void setGreenBorder() {
		System.out.println("Border Color: Red");

	}

}
