package com.udemy.basic.dp.structural.composite;

public class Developer implements Employee {
	private String name;
	private long id;
	private String position;

	public Developer(String name, long id, String position) {
		super();
		this.name = name;
		this.id = id;
		this.position = position;
	}

	@Override
	public void showEmplyoeeDetails() {
		System.out.println("EmpdId: " + id + " , Name: " + name + " , Position: " + position);
	}

}
