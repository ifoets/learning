package com.udemy.basic.dp.creational.abstractfactory;

public class ColorFactory extends AbstractFactory {

	@Override
	public IColor getColor(String color) {

		if (color.equalsIgnoreCase("RED"))
			return new Red();
		else if (color.equalsIgnoreCase("BLUE"))
			return new Blue();
		else if (color.equalsIgnoreCase("GREEN"))
			return new Green();
		return null;
	}

	@Override
	public IShape getShape(String shape) {
		return null;
	}

}
