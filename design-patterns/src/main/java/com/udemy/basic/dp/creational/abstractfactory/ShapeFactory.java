package com.udemy.basic.dp.creational.abstractfactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	public IColor getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IShape getShape(String shape) {

		if (shape.equalsIgnoreCase("CIRCLE"))
			return new Circle();
		else if (shape.equalsIgnoreCase("RECTANGLE"))
			return new Rectangle();
		else if (shape.equalsIgnoreCase("SQUARE"))
			return new Square();
		return null;
	}

}
