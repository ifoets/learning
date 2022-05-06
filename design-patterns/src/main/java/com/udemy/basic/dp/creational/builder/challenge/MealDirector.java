package com.udemy.basic.dp.creational.builder.challenge;

public class MealDirector {

	IMealBuilder myBuilder;

	public void construct(IMealBuilder builder) {
		myBuilder = builder;
		myBuilder.buildBurger();
		myBuilder.buildDrink();

	}
}
