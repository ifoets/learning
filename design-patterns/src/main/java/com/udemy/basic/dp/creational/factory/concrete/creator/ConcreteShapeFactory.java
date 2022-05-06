package com.udemy.basic.dp.creational.factory.concrete.creator;

import com.udemy.basic.dp.creational.factory.abstr.creator.Circle;
import com.udemy.basic.dp.creational.factory.abstr.creator.Rectangle;
import com.udemy.basic.dp.creational.factory.abstr.creator.Shape;
import com.udemy.basic.dp.creational.factory.abstr.creator.Square;

public  class ConcreteShapeFactory {

	//protected abstract Shape factoryMethod();

	public Shape getShape(String shape) {

		if (shape.equalsIgnoreCase("CIRCLE"))
			return new Circle();
		else if (shape.equalsIgnoreCase("RECTANGLE"))
			return new Rectangle();
		else if (shape.equalsIgnoreCase("SQUARE"))
			return new Square();
		return null;
	}
}
