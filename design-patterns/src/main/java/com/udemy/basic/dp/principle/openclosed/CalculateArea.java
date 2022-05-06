package com.udemy.basic.dp.principle.openclosed;

public class CalculateArea {
//stopped any modification for calculate Area of any new shape
	public double calculateArea(Shape s) {
		return s.calculateArea();
	}
}
