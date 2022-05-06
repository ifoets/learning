package com.udemy.basic.dp.structural;

public interface IStructuralDp {

	/** Adapter design pattern */
	/*
	 * Object Adapter by Composition, Turkey/Duck Example, Turkey behaves like Duck
	 */
	public void adapterByCompositionEx1();

	/*
	 * Object Adapter by Composition, Calculator/Rectangle/Triangle, calculating
	 * area of triangle using area calculator of Rectangle
	 */
	public void adapterByCompositionEx2();

	/* by using object composition */
	public void adapterByObjectComp();

	/* by using interface implementation */
	public void adapterByInterfaceImpl();

	/* by using composition implementation challenge */
	public void adapterByCompositionChallenge();

	/** Bridge design pattern **/

	/* Bridge design pattern Example */
	public void bridgePatternExample();

	/* Bridge design pattern Challenge */
	public void bridgePatternChallenge();

	/** Composite design pattern **/

	/* Composite design pattern exampleX */
	public void compositePatternExampleX();

	/* Composite design pattern exampleX */
	public void compositePatternExampleY();

	/* Composite design pattern Challenge */
	public void compositePatternChallenge();

	/** Decorator design pattern */

	/* Decorator design pattern example */
	public void decoratorPatternExample();

	/* Decorator design pattern example File IO */
	public void decoratorPatternExamFileIo(String str);

	/* Decorator design pattern example File IO */
	public void decoratorPatternChallenge();

	/** Facade Design Pattern **/

	/* Facade design pattern example */
	public void facadePatternExample();

	/* Facade design pattern challenge */
	public void facadePatternChallenge();

	/** Flyweight design pattern */

	/* Flyweight design pattern Example */
	public void flyWeightPatternExample();

	/* Flyweight design pattern Challenge */
	public void flyWeightPatternChallenge();

	/** Proxy design Pattern */

	/* Proxy design Pattern Example */
	public void proxyPatternExample();
	
	/* Proxy design Pattern Challenge */
	public void proxyPatternChallenge();

}
