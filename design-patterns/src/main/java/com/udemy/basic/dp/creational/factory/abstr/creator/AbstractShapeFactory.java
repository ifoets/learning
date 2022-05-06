package com.udemy.basic.dp.creational.factory.abstr.creator;

public abstract class AbstractShapeFactory {

	protected abstract Shape factoryMethod();

	public Shape getShape() {
		return factoryMethod();
	}

	// others helper methods
}
