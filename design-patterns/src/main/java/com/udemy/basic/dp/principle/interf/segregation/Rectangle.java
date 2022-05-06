package com.udemy.basic.dp.principle.interf.segregation;

public class Rectangle implements IShape, IManageShape {

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculate() {
		return this.area();
	}

}
