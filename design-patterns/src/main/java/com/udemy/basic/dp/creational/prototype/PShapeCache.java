package com.udemy.basic.dp.creational.prototype;

import java.util.Hashtable;

public class PShapeCache {

	private static Hashtable<String, PShape> shapeMap = new Hashtable<>();

	public static PShape getShape(String id) {
		PShape cachedShape = shapeMap.get(id);
		return (PShape) cachedShape.clone();
	}

	public static void loadCache() {
		PCircle circle = new PCircle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		PSquare square = new PSquare();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		PRectangle rectangle = new PRectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
