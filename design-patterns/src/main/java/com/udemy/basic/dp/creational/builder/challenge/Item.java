package com.udemy.basic.dp.creational.builder.challenge;

interface Packing {
	public String pack();
}

class Wrpper implements Packing {

	@Override
	public String pack() {
		return "Wrapper";
	}

}

class Bottel implements Packing {

	@Override
	public String pack() {
		return "Bottel";
	}

}

public interface Item {

	public String name();

	public float price();

	public Packing packing();
}

abstract class Burger implements Item {
	@Override
	public Packing packing() {
		return new Wrpper();
	}
}

class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veg-Burger";
	}

	@Override
	public float price() {
		return 25.0f;
	}
}

class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "Chicken-Burger";
	}

	@Override
	public float price() {
		return 50.0f;
	}

}

abstract class ColDrink implements Item {
	@Override
	public Packing packing() {
		return new Wrpper();
	}
}

class Coke extends ColDrink {

	@Override
	public String name() {
		return "Coke";
	}

	@Override
	public float price() {
		return 15.0f;
	}
}

class Pepsi extends ColDrink {

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 20.0f;
	}
}
