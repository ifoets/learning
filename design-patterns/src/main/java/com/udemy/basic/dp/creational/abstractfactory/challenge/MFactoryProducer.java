package com.udemy.basic.dp.creational.abstractfactory.challenge;

public class MFactoryProducer {

	public static IIMoveFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("BollyWood"))
			return new BollywoodMoveFactory();
		else if (choice.equalsIgnoreCase("HollyWood"))
			return new HollywoodMoveFactory();

		return null;
	}
}
