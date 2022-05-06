package com.udemy.basic.dp.structural.adapter.obj.ex2;

public class Calculator implements ICalculator {

	@SuppressWarnings("unused")
	private Rectangle rectangle;

	@Override
	public double getArea(Rectangle rectangle) {
		this.rectangle = rectangle;
		return rectangle.height * rectangle.length;
	}
}
