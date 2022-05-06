package com.udemy.basic.dp.creational.singleton;

import java.util.Random;

public class Caption {

	// an instance attribute
	private static String names[] = { "aaa", "bbb", "ccc", "ddd", "eee", "ggg", "hhh", "iii", "jjj", "kkk", "lll" };

	/*
	 * The Single Constructor Note that it is private No Client instantiate a
	 * Singleton Object
	 */
	private Caption() {
	}

	private static class SingtonHelper {
		private static final Caption uniqueInstance = new Caption();
		private static String name = names[new Random().nextInt(names.length)];
	}

	public static Caption getInstance() {

		return SingtonHelper.uniqueInstance;
	}

	public String getName() {
		return SingtonHelper.name;
	}
}
