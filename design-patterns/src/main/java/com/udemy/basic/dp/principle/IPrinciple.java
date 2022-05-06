package com.udemy.basic.dp.principle;

import com.udemy.basic.dp.principle.delegation.principle.Printer;
import com.udemy.basic.dp.principle.dependency.injection.Client;
import com.udemy.basic.dp.principle.liskov.substituation.Vehicle;
import com.udemy.basic.dp.principle.openclosed.Shape;
import com.udemy.basic.dp.principle.programming.to.interfce.ComputerDisplay;

public interface IPrinciple {

	/** Programming to an Interface */
	public void programmingToInterface(ComputerDisplay cd);

	/** Delegation principles */
	public void delegate(Printer printer);

	// **single Responsibility**/
	// @see com.udemy.basic.dp.principle.single.responsibility.Emplyoee

	/** Open closed principle **/
	public double openCosedPrinciple(Shape shape);

	/** Liskov Substitution principle */
	public void liskovesubsitution(Vehicle v);

	/** Interface segregation principle */
	// @See com.udemy.basic.dp.principle.interf.segregation

	/** dependency inversion principle */
	// @see com.udemy.basic.dp.principle.dependency.inversion

	/** Inversion principle */
	public void inversionPrinciple(Client client);
}
