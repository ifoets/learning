package com.udemy.basic.dp.creational.abstractfactory.challenge;

public class BollywoodMoveFactory implements IIMoveFactory {

	@Override
	public IHollywoodMovie getHollywoodMovie(String type) {
		return null;
	}

	@Override
	public IBollywoodMovie getBollywoodMovie(String type) {
		if (type.equalsIgnoreCase("action"))
			return new BollywoodActionMovie();
		else if (type.equalsIgnoreCase("comedy"))
			return new BollywoodComedyMovie();
		else
			return null;
	}

}
