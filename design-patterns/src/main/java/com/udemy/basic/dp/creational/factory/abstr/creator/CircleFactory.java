package com.udemy.basic.dp.creational.factory.abstr.creator;

public class CircleFactory extends AbstractShapeFactory {

	@Override
	protected Shape factoryMethod() {
		return new Circle();
	}

}
