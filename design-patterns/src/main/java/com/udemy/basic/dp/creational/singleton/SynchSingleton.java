package com.udemy.basic.dp.creational.singleton;

public class SynchSingleton {

	// the private reference to one and only one instance
	private static SynchSingleton uniqueInstance = null;

	// an instance attribute
	private int data = 0;

	/*
	 * The Single Constructor Note that it is private No Client instantiate a
	 * Singleton Object
	 */
	private SynchSingleton() {
	}

	// Synchronised keyword, we force every thread to wait its turn before it can
	// enter the method
	public static SynchSingleton getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new SynchSingleton();
		return uniqueInstance;
	}

	public void setData(int myData) {
		data = myData;
	}

	public int getData() {
		return data;
	}

}
