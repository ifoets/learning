package com.udemy.basic.dp.creational.abstractfactory.challenge;

public class ComedyMoveFactory implements IMoveFactory {

	@Override
	public IHollywoodMovie getHollywoodMovie() {
		return new HollywoodComedyMovie();
	}

	@Override
	public IBollywoodMovie getBollywoodMovie() {
		return new BollywoodComedyMovie();
	}

}
