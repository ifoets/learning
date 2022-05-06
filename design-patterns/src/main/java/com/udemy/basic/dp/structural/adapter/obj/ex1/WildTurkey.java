package com.udemy.basic.dp.structural.adapter.obj.ex1;

public class WildTurkey implements ITurkey {

	@Override
	public void gobble() {
		System.out.println("Gobble gobble");
	}

	@Override
	public void fly() {
		System.out.println("I am flying a short distance");
	}

}
