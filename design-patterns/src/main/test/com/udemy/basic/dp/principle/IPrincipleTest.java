package com.udemy.basic.dp.principle;

import org.junit.Before;
import org.junit.Test;

import com.udemy.basic.dp.principle.delegation.principle.Printer;
import com.udemy.basic.dp.principle.dependency.injection.Client;
import com.udemy.basic.dp.principle.dependency.injection.IService;
import com.udemy.basic.dp.principle.dependency.injection.ServiceImpl;
import com.udemy.basic.dp.principle.liskov.substituation.Bus;
import com.udemy.basic.dp.principle.liskov.substituation.Car;
import com.udemy.basic.dp.principle.liskov.substituation.Vehicle;
import com.udemy.basic.dp.principle.openclosed.Circle;
import com.udemy.basic.dp.principle.openclosed.Rectangle;
import com.udemy.basic.dp.principle.openclosed.Shape;
import com.udemy.basic.dp.principle.programming.to.interfce.ComputerDisplay;
import com.udemy.basic.dp.principle.programming.to.interfce.DisplayModule;
import com.udemy.basic.dp.principle.programming.to.interfce.Monitor;
import com.udemy.basic.dp.principle.programming.to.interfce.Projector;

public class IPrincipleTest {

	IPrinciple ip;

	@Before
	public void init() {
		ip = new PrincipleImpl();
	}

	@Test
	public void programmingToInterfaceTest() {
		ComputerDisplay cd = new ComputerDisplay();
		DisplayModule dm1 = new Monitor();
		DisplayModule dm2 = new Projector();
		cd.setDisplayModule(dm1);
		ip.programmingToInterface(cd);
		System.out.println("-------X---------------X----------");
		cd.setDisplayModule(dm2);
		ip.programmingToInterface(cd);
	}

	/** Delegation principles */
	@Test
	public void delegateTest() {
		ip.delegate(new Printer());
	}

	// **single Responsibility**/
	// @see com.udemy.basic.dp.principle.single.responsibility.Emplyoee

	/** Open closed principle **/
	@Test
	public void openCosedPrincipleTest() {

		Shape s1 = new Rectangle(10, 20);
		System.out.println("Area of Rectangle :" + ip.openCosedPrinciple(s1));

		Shape s2 = new Circle(100);
		System.out.println("Area of Circle :" + ip.openCosedPrinciple(s2));
	}

	/** Liskov Substitution principle */
	@Test
	public void liskovesubsitutionTest() {

		Vehicle veh1 = new Car();
		ip.liskovesubsitution(veh1);
		System.out.println("-----X-------X-------");
		Vehicle veh2 = new Bus();
		ip.liskovesubsitution(veh2);
	}

	/** Interface segregation principle */
	// @See com.udemy.basic.dp.principle.interf.segregation

	/** dependency inversion principle */
	// @see com.udemy.basic.dp.principle.dependency.inversion

	/** Inversion principle */
	@Test
	public void inversionPrincipleTest() {
		IService service = new ServiceImpl();
		// constructor injection
		Client client = new Client(service);
		ip.inversionPrinciple(client);

		// setter injection
		client.setService(service);
		ip.inversionPrinciple(client);
	}
}
