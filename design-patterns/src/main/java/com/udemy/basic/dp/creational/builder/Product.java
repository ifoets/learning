package com.udemy.basic.dp.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {
	public List<String> parts = null;

	Product() {
		parts = new ArrayList<>();
	}

	public void add(String str) {
		parts.add(str);
	}

	public void show() {
		System.out.println("\n Product completed as below");
		for (String str : parts)
			System.out.println(str);
	}
}
