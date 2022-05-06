package com.udemy.basic.dp.creational.singleton;

public class EagerSingleton {

	// static initialisation thread safe guaranteed
	private static EagerSingleton uniqueInstance = new EagerSingleton();

	// an instance attribute
	private int data = 0;

	/*
	 * The Single Constructor Note that it is private No Client instantiate a
	 * Singleton Object
	 */
	private EagerSingleton() {
	}

	public static EagerSingleton getInstance() {
		// we already got instance just have to return it
		return uniqueInstance;
	}

	public void setData(int myData) {
		data = myData;
	}

	public int getData() {
		return data;
	}

}
