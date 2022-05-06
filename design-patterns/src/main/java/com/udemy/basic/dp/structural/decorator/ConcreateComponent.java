package com.udemy.basic.dp.structural.decorator;

public class ConcreateComponent extends Component {

	@Override
	public void doJob() {
		System.out.println("I am Concreate a Component- I am closed for modificatioin");
	}
}
