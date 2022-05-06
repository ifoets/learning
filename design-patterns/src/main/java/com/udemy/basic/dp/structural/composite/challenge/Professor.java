package com.udemy.basic.dp.structural.composite.challenge;

public class Professor implements Faculty {
	private String name;
	private String position;
	@SuppressWarnings("unused")
	private int officeNum;

	public Professor(String name, String position, int officeNum) {
		super();
		this.name = name;
		this.officeNum = officeNum;
		this.position = position;
	}

	@Override
	public String getDetails() {
		return name + " , is the " + position;
	}

}
