package com.udemy.basic.dp.structural.decorator.challenge;

public class GreenShapeDecorator extends ShapeDecorator {

	public GreenShapeDecorator(IDecoShape shape) {
		super(shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		super.draw();
		setGreenBorder();
	}

	private void setGreenBorder() {
		System.out.println("Border Color: Green");

	}

}
