package com.udemy.basic.dp.principle.programming.to.interfce;

/*Programming to interface*/

public class ComputerDisplay {

	DisplayModule dm;

	public void setDisplayModule(DisplayModule dm) {
		this.dm = dm;
	}

	public void display() {
		dm.display();
	}
}
