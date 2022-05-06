package com.udemy.basic.dp.creational.builder.challenge;

public class NonVegMealBuilder implements IMealBuilder {
	Meal vegMeal = new Meal();

	@Override
	public void buildBurger() {
		vegMeal.addItem(new ChickenBurger());

	}

	@Override
	public void buildDrink() {
		vegMeal.addItem(new Pepsi());

	}

	@Override
	public Meal getMeal() {
		return vegMeal;
	}

}
