package com.udemy.basic.dp.structural;

import org.junit.Before;
import org.junit.Test;

public class IStructuralDpTest {

	IStructuralDp isd = null;

	@Before
	public void init() {
		isd = new StructuralDpImpl();
	}

	/** Adapter design pattern */

	/*
	 * Object Adapter by Composition, Turkey/Duck Example, Turkey behaves like Duck
	 */
	@Test
	public void adapterByCompositionEx1Test() {
		isd.adapterByCompositionEx1();
	}

	/*
	 * Object Adapter by Composition, Calculator/Rectangle/Triangle, calculating
	 * area of triangle using area calculator of Rectangle
	 */
	@Test
	public void adapterByCompositionEx2Test() {
		isd.adapterByCompositionEx2();
	}

	/* by using object composition */
	@Test
	public void adapterByObjectCompTest() {
		isd.adapterByObjectComp();
	}

	/* by using interface implementation */
	@Test
	public void adapterByInterfaceImplTest() {
		isd.adapterByInterfaceImpl();
	}

	/* by using composition implementation challenge */
	@Test
	public void adapterByCompositionChallengeTest() {
		isd.adapterByCompositionChallenge();
	}

	/** Bridge design pattern **/

	/* Bridge design pattern Example */
	@Test
	public void bridgePatternExampleTest() {
		isd.bridgePatternExample();
	}

	/* Bridge design pattern Challenge */
	@Test
	public void bridgePatternChallengeTest() {
		isd.bridgePatternChallenge();
	}

	/* Composite design pattern exampleX */
	@Test
	public void compositePatternExampleXTest() {
		isd.compositePatternExampleX();
	}

	/* Composite design pattern exampleY */
	@Test
	public void compositePatternExampleYTest() {
		isd.compositePatternExampleY();
	}

	/* Composite design pattern Challenge */
	@Test
	public void compositePatternChallengeTest() {
		isd.compositePatternChallenge();
	}

	/** Decorator design pattern */

	/* Decorator design pattern example */
	@Test
	public void decoratorPatternExampleTest() {
		isd.decoratorPatternExample();
	}

	/* Decorator design pattern example File IO */
	@Test
	public void decoratorPatternExamFileIoTest() {
		String str = "Jason Fedin aaaBBBBcccDDDDs";
		isd.decoratorPatternExamFileIo(str);
	}

	/* Decorator design pattern example File IO */
	@Test
	public void decoratorPatternChallenge() {
		isd.decoratorPatternChallenge();
	}

	/** Facade Design Pattern **/

	/* Facade design pattern example */
	@Test
	public void facadePatternExampleTest() {
		isd.facadePatternExample();
	}

	/* Facade design pattern challenge */
	@Test
	public void facadePatternChallengeTest() {
		isd.facadePatternChallenge();
	}

	/** Flyweight design pattern */

	/* Flyweight design pattern Example */
	@Test
	public void flyWeightPatternExampleTest() {
		isd.flyWeightPatternExample();
	}

	/* Flyweight design pattern Challenge */
	@Test
	public void flyWeightPatternChallengeTest() {
		isd.flyWeightPatternChallenge();
	}

	/** Proxy design Pattern */

	/* Proxy design Pattern Example */
	@Test
	public void proxyPatternExampleTest() {
		isd.proxyPatternExample();
	}

	/* Proxy design Pattern Challenge */
	@Test
	public void proxyPatternChallengeTest() {
		isd.proxyPatternChallenge();
	}
}
