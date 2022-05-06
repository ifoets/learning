package com.udemy.basic.dp.principle.dependency.injection;

public class Client {

	private IService service;

	// injection via constructor
	public Client(IService service) {
		this.service = service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	public void doSomething() {
		service.write("This is message from Injection");
	}
}
