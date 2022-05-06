package com.udemy.basic.dp.structural.composite;

public class Manager implements Employee {
	private String name;
	private long id;
	private String position;

	public Manager(String name, long id, String position) {
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
