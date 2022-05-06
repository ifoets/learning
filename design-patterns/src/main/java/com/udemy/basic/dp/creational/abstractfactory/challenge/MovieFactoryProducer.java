package com.udemy.basic.dp.creational.abstractfactory.challenge;

public class MovieFactoryProducer {

	public static IMoveFactory getFactory(String choice) {
		
		if (choice.equalsIgnoreCase("Comedy"))
			return new ComedyMoveFactory();
		else if (choice.equalsIgnoreCase("Action"))
			return new ActionMoveFactory();
		
		return null;
	}
}
