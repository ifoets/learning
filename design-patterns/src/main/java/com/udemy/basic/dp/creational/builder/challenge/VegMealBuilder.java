package com.udemy.basic.dp.creational.builder.challenge;

public class VegMealBuilder implements IMealBuilder {
	Meal vegMeal = new Meal();

	@Override
	public void buildBurger() {
		vegMeal.addItem(new VegBurger());

	}

	@Override
	public void buildDrink() {
		vegMeal.addItem(new Coke());

	}

	@Override
	public Meal getMeal() {
		return vegMeal;
	}

}
