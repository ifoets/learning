package com.udemy.basic.dp.creational.factory.challenge;

public abstract class AbstractAnimalFactory {
	public abstract IAnimal getAnimalType(String animal) throws Exception;
}