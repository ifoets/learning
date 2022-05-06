package com.udemy.basic.dp.creational.singleton;

public class DoubleLockSingleton {

	// the private reference to one and only one instance
	private volatile static DoubleLockSingleton uniqueInstance = null;

	// an instance attribute
	private int data = 0;

	/*
	 * The Single Constructor Note that it is private No Client instantiate a
	 * Singleton Object
	 */
	private DoubleLockSingleton() {
	}

	// Synchronised keyword, we force every thread to wait its turn before it can
	// enter the method
	public static DoubleLockSingleton getInstance() {
		if (uniqueInstance == null) {
			// we only synchronise only first time through
			synchronized (DoubleLockSingleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new DoubleLockSingleton();
				}

			}
		}

		return uniqueInstance;
	}

	public void setData(int myData) {
		data = myData;
	}

	public int getData() {
		return data;
	}

}
