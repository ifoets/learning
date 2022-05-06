package com.udemy.basic.dp.creational.factory.stc.method.creator;

import com.udemy.basic.dp.creational.factory.abstr.creator.Circle;
import com.udemy.basic.dp.creational.factory.abstr.creator.Rectangle;
import com.udemy.basic.dp.creational.factory.abstr.creator.Shape;
import com.udemy.basic.dp.creational.factory.abstr.creator.Square;

public  class StaticShapeFactory {

	//protected abstract Shape factoryMethod();

	public static Shape getShape(String shape) {

		if (shape.equalsIgnoreCase("CIRCLE"))
			return new Circle();
		else if (shape.equalsIgnoreCase("RECTANGLE"))
			return new Rectangle();
		else if (shape.equalsIgnoreCase("SQUARE"))
			return new Square();
		return null;
	}
}
