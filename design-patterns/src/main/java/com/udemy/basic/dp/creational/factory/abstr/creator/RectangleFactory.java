package com.udemy.basic.dp.creational.factory.abstr.creator;

public class RectangleFactory extends AbstractShapeFactory {

	@Override
	protected Shape factoryMethod() {
		return new Rectangle();
	}

}
