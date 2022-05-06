package com.udemy.basic.dp.creational.abstractfactory.challenge;

//another way Holly/Bollywood  instead of Action/Comedy based
public interface IIMoveFactory {

	public IHollywoodMovie getHollywoodMovie(String type);

	public IBollywoodMovie getBollywoodMovie(String type);
}
