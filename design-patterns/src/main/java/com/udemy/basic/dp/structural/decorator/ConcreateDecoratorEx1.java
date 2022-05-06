package com.udemy.basic.dp.structural.decorator;

public class ConcreateDecoratorEx1 extends AbstractDecorator {

	public void doJob() {
		super.doJob();

		// add additional responsibilities
		System.out.println("I am Explicity from  Ex1");
	}
}
