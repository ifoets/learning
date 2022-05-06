package com.udemy.basic.dp.creational.abstractfactory.challenge;

public class HollywoodMoveFactory implements IIMoveFactory {

	@Override
	public IHollywoodMovie getHollywoodMovie(String type) {
		if (type.equalsIgnoreCase("action"))
			return new HollywoodActionMovie();
		else if (type.equalsIgnoreCase("comedy"))
			return new HollywoodComedyMovie();
		else
			return null;
	}

	@Override
	public IBollywoodMovie getBollywoodMovie(String type) {
		return null;
	}

}
