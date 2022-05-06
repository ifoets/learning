package com.udemy.basic.dp.creational.factory.abstr.creator;

public class SquareFactory extends AbstractShapeFactory {

	@Override
	protected Shape factoryMethod() {
		return new Square();
	}

}
