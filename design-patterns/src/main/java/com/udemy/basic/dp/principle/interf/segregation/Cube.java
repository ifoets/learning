package com.udemy.basic.dp.principle.interf.segregation;

public class Cube implements IShape, ISolidShape, IManageShape {

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculate() {
		return this.area() + this.volume();
	}

}
