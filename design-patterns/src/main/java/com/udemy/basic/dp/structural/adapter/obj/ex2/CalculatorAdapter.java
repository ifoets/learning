package com.udemy.basic.dp.structural.adapter.obj.ex2;

public class CalculatorAdapter implements ICalculator {

	Triangle triangle;
	Calculator cal;

	public CalculatorAdapter(Triangle triangle) {
		this.triangle = triangle;
	}

	@Override
	public double getArea(Rectangle rectangle) {
		cal = new Calculator();
		rectangle.length = triangle.base;
		rectangle.height = 0.5 * triangle.height;

		return cal.getArea(rectangle);
	}

}
