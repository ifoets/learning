package com.udemy.basic.dp.creational.abstractfactory.challenge;

public class ActionMoveFactory implements IMoveFactory {

	@Override
	public IHollywoodMovie getHollywoodMovie() {
		return new HollywoodActionMovie();
	}

	@Override
	public IBollywoodMovie getBollywoodMovie() {
		return new BollywoodActionMovie();
	}

}
