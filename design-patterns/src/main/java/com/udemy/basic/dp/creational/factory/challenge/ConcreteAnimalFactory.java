package com.udemy.basic.dp.creational.factory.challenge;

public class ConcreteAnimalFactory extends AbstractAnimalFactory {

	@Override
	public IAnimal getAnimalType(String animal) throws Exception {
		animal = animal.toUpperCase();
		switch (animal) {
		case "DUCK":
			return new Duck();
			
		case "TIGER":
			return new Tiger();
			
		default:
			throw new Exception("Animal Type: " + animal + " can not instantiate");
		}
	}

}
