package com.udemy.basic.dp.structural.composite.challenge;

import java.util.ArrayList;
import java.util.List;

public class Supervisor implements Faculty {
	public List<Faculty> list;
	private String name;
	private String deptName;

	public Supervisor(String name, String deptName) {
		super();
		this.name = name;
		this.deptName = deptName;
		list = new ArrayList<>();
	}

	public void add(Faculty faculty) {
		list.add(faculty);
	}

	public void remove(Faculty faculty) {
		list.remove(faculty);
	}

	public Faculty getMyFaculty(int index) {
		return list.get(index);
	}

	public void showDetails() {
		System.out.println("Dean..");
		System.out.println(getDetails());
		for (Faculty faculty : list) {
			System.out.println(faculty.getDetails());
			if (faculty instanceof Supervisor) {
				Supervisor sup = (Supervisor) faculty;
				for (Faculty professor : sup.list)
					System.out.println(professor.getDetails());
			}
		}
	}

	@Override
	public String getDetails() {
		return "Name: " + name + "Department Name: " + deptName;
	}
}
