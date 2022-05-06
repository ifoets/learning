package com.udemy.basic.dp.creational.singleton;

public class BillPughSingleton {

	// an instance attribute
	private int data = 0;

	/*
	 * The Single Constructor Note that it is private No Client instantiate a
	 * Singleton Object
	 */
	private BillPughSingleton() {
	}

	private static class SingtonHelper {
		private static final BillPughSingleton uniqueInstance = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingtonHelper.uniqueInstance;
	}

	public void setData(int myData) {
		data = myData;
	}

	public int getData() {
		return data;
	}

}
