package com.udemy.basic.dp.principle.interf.segregation;

public interface IShape {
	
	public double area();

	// it break the interface segregation plane area have force to implement but it
	// have,t any volume, it need to segregation
	// public double volume();

}
