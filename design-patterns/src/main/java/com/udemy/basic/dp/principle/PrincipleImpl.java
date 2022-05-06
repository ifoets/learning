package com.udemy.basic.dp.principle;

import com.udemy.basic.dp.principle.delegation.principle.Printer;
import com.udemy.basic.dp.principle.dependency.injection.Client;
import com.udemy.basic.dp.principle.liskov.substituation.Vehicle;
import com.udemy.basic.dp.principle.openclosed.Shape;
import com.udemy.basic.dp.principle.programming.to.interfce.ComputerDisplay;

public class PrincipleImpl implements IPrinciple {

	/** Programming to an Interface */
	@Override
	public void programmingToInterface(ComputerDisplay cd) {
		cd.display();
	}

	/** Delegation principles */
	@Override
	public void delegate(Printer printer) {
		// its looks like Printer is printing but it delegate this work to RealPrinter
		printer.print();
	}

	// **single Responsibility**/
	// @see com.udemy.basic.dp.principle.single.responsibility.Emplyoee

	/** Open closed principle **/
	public double openCosedPrinciple(Shape shape) {
		return shape.calculateArea();
	}

	/** Liskov Substitution principle */
	public void liskovesubsitution(Vehicle v) {
		v.getSpeed();
		v.getCubicCapicity();
	}

	/** Interface segregation principle */
	// @See com.udemy.basic.dp.principle.interf.segregation

	/** dependency inversion principle */
	// @see com.udemy.basic.dp.principle.dependency.inversion

	/** Inversion principle */
	public void inversionPrinciple(Client client) {
		client.doSomething();
	}

}
