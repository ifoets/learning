package com.basic.udmy.webflux.utils;

public class SleepUtil {

	public static void sleepSecond(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
