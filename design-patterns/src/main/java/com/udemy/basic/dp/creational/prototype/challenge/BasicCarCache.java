package com.udemy.basic.dp.creational.prototype.challenge;

import java.util.Hashtable;

public class BasicCarCache {

	private static Hashtable<String, BasicCar> carMap = new Hashtable<>();

	public static BasicCar getModel(String model) {
		BasicCar cachedCar = carMap.get(model);
		return (BasicCar) cachedCar.clone();
	}

	public static void loadCache() {
		Nano nano = new Nano();
		nano.setModel("Green Nano");
		carMap.put(nano.getModel(), nano);

		Ford ford = new Ford();
		ford.setModel("Yellow Ford");
		carMap.put(ford.getModel(), ford);
	}
}
