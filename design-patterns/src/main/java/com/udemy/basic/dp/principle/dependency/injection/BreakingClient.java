package com.udemy.basic.dp.principle.dependency.injection;

/*violet the dependency injection by hard dependency by creating new object rather to use one initialised one
this way any change in ExampleService need to change in BreakingClient, for testing BreakingClient need to test ExampleService
also*/
public class BreakingClient {

	// Internal reference to the service used by this BreakingClient
	@SuppressWarnings("unused")
	private ExampleService service;

	BreakingClient() {
		// specify the specific implementation in the constructor instead of using
		// dependency injection
		service = new ExampleService();
	}

	// method within this client that use the services
	public String greet() {
		return "Hello" + service.getName();
	}
}
