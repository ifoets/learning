package com.udemy.basic.dp.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Director implements Employee {

	public List<Employee> list = new ArrayList<>();

	private String name;
	private double salary;

	public Director(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public void showEmplyoeeDetails() {
		System.out.println("Director details: ");
		System.out.println("Name: " + name + " , Salary: " + salary);
		for (Employee emp : list)
			emp.showEmplyoeeDetails();
	}

	public void addEmployee(Employee emp) {
		list.add(emp);
	}

	public void removeEmplyoee(Employee emp) {
		list.remove(emp);
	}

	public Employee getChild(int i) {
		return list.get(i);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
