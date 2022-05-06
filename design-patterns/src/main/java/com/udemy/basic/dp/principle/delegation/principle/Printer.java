package com.udemy.basic.dp.principle.delegation.principle;

class RealPrinter {
	// delegate
	public void print() {
		System.out.println("The Delegate...printing happing here only");
	}
}

public class Printer {
//delegator
	RealPrinter realPrinter = new RealPrinter();

	// delegator
	public void print() {
		realPrinter.print();// delegate
	}
}
