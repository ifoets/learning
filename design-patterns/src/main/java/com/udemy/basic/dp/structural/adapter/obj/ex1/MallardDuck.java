package com.udemy.basic.dp.structural.adapter.obj.ex1;

public class MallardDuck implements IDuck {

	@Override
	public void quack() {
		System.out.println("Quark quark");
	}

	@Override
	public void fly() {
		System.out.println("I am Flying");
	}
}
