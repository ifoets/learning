package com.udemy.basic.dp.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Employee {

	public List<Employee> list = new ArrayList<>();

	@Override
	public void showEmplyoeeDetails() {
		for (Employee emp : list)
			emp.showEmplyoeeDetails();
	}

	public void addEmployee(Employee emp) {
		list.add(emp);
	}

	public void removeEmplyoee(Employee emp) {
		list.remove(emp);
	}
}
