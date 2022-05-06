package com.udemy.basic.dp.creational.singleton;

public class LazySingleton {

	// the private reference to one and only one instance
	private static LazySingleton uniqueInstance = null;

	// an instance attribute
	private int data = 0;

	/*
	 * The Single Constructor Note that it is private No Client instantiate a
	 * Singleton Object
	 */
	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new LazySingleton();
		return uniqueInstance;
	}

	public void setData(int myData) {
		data = myData;
	}

	public int getData() {
		return data;
	}

}
