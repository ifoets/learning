package com.udemy.basic.dp.creational;

import org.junit.Before;
import org.junit.Test;

import com.udemy.basic.dp.creational.builder.Car;
import com.udemy.basic.dp.creational.builder.IVehicleBuilder;
import com.udemy.basic.dp.creational.builder.MotorCycle;
import com.udemy.basic.dp.creational.builder.challenge.IMealBuilder;
import com.udemy.basic.dp.creational.builder.challenge.NonVegMealBuilder;
import com.udemy.basic.dp.creational.builder.challenge.VegMealBuilder;
import com.udemy.basic.dp.creational.factory.abstr.creator.CircleFactory;
import com.udemy.basic.dp.creational.factory.abstr.creator.RectangleFactory;
import com.udemy.basic.dp.creational.factory.abstr.creator.Shape;
import com.udemy.basic.dp.creational.factory.abstr.creator.SquareFactory;
import com.udemy.basic.dp.creational.factory.challenge.ConcreteAnimalFactory;
import com.udemy.basic.dp.creational.factory.challenge.IAnimal;
import com.udemy.basic.dp.creational.factory.concrete.creator.ConcreteShapeFactory;
import com.udemy.basic.dp.creational.factory.stc.method.creator.StaticShapeFactory;
import com.udemy.basic.dp.creational.singleton.BillPughSingleton;
import com.udemy.basic.dp.creational.singleton.Caption;
import com.udemy.basic.dp.creational.singleton.DoubleLockSingleton;
import com.udemy.basic.dp.creational.singleton.EagerSingleton;
import com.udemy.basic.dp.creational.singleton.LazySingleton;
import com.udemy.basic.dp.creational.singleton.SynchSingleton;

public class ICreationalDpTest {

	ICreationalDp idp = null;

	@Before
	public void init() {
		idp = new CreationalDpImpl();
	}

	/** Factory Design Pattern **/

	/* Factory pattern : abstract creator */
	@Test
	public void factoryAbstractCreatorTest() {

		Shape shap1 = new CircleFactory().getShape();
		idp.factoryAbstractCreator(shap1);
		System.out.println("----------------X---------------X-----------");
		Shape shap2 = new RectangleFactory().getShape();
		idp.factoryAbstractCreator(shap2);
		System.out.println("----------------X---------------X-----------");
		Shape shap3 = new SquareFactory().getShape();
		idp.factoryAbstractCreator(shap3);

	}

	/* Factory pattern : concrete creator */
	@Test
	public void factoryConcreteCreatorTest() {

		ConcreteShapeFactory factory = new ConcreteShapeFactory();
		Shape shap1 = factory.getShape("CIRCLE");
		idp.factoryConcreteCreator(shap1);
		System.out.println("----------------X---------------X-----------");
		Shape shap2 = factory.getShape("RECTANGLE");
		idp.factoryConcreteCreator(shap2);
		System.out.println("----------------X---------------X-----------");
		Shape shap3 = factory.getShape("SQUARE");
		idp.factoryConcreteCreator(shap3);
	}

	/* Factory pattern : Static creator */
	@Test
	public void factoryStaticCreatorTest() {
		// ConcreteShapeFactory factory = new ConcreteShapeFactory();
		Shape shap1 = StaticShapeFactory.getShape("CIRCLE");
		idp.factoryConcreteCreator(shap1);
		System.out.println("----------------X---------------X-----------");
		Shape shap2 = StaticShapeFactory.getShape("RECTANGLE");
		idp.factoryConcreteCreator(shap2);
		System.out.println("----------------X---------------X-----------");
		Shape shap3 = StaticShapeFactory.getShape("SQUARE");
		idp.factoryConcreteCreator(shap3);
	}

	/* challenge task for use create/use factory */
	@Test
	public void factoryChallengeTest() throws Exception {
		ConcreteAnimalFactory factory = new ConcreteAnimalFactory();
		IAnimal animal1 = factory.getAnimalType("DUCK");
		idp.factoryChallenge(animal1);
		System.out.println("----------------X---------------X-----------");
		IAnimal animal2 = factory.getAnimalType("TiGER");
		idp.factoryChallenge(animal2);

		System.out.println("----------------X---------------X-----------");
		try {
			IAnimal animal3 = factory.getAnimalType("Lion");
			idp.factoryChallenge(animal3);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	/** Abstract Factory design pattern **/
	@Test
	public void abstractFactoryExmapleTest() {

		idp.abstractFactoryExmaple("COLOR", "Red");
		idp.abstractFactoryExmaple("COLOR", "Blue");
		idp.abstractFactoryExmaple("COLOR", "Green");

		System.out.println("-----X-------------------X---------");
		idp.abstractFactoryExmaple("SHAPE", "Circle");
		idp.abstractFactoryExmaple("SHAPE", "Rectangle");
		idp.abstractFactoryExmaple("SHAPE", "Square");
	}

	/* Abstract Factory design pattern Challenge */
	/* first approach */
	@Test
	public void absractFactoryChallengeTest() {
		idp.absractFactoryChallengeX("Action");
		System.out.println("-----------X----------X");
		idp.absractFactoryChallengeX("Comedy");
	}

	/* second approach */
	@Test
	public void absractFactoryChallengeYTest() {
		idp.absractFactoryChallengeY("hollywood");
		System.out.println("-----------X----------X");
		idp.absractFactoryChallengeY("bollywood");
	}

	/** Singleton Design pattern */

	@SuppressWarnings("null")
	/* Lazy singleton example */
	@Test
	public void getlazySingletonTest() {

		LazySingleton s1 = idp.getLazySingleton();
		s1.setData(55);
		System.out.println("The first reference: " + s1);
		System.out.println("The first data: " + s1.getData());

		System.out.println("-------X--------------X--------");
		s1 = null;
		LazySingleton s2 = idp.getLazySingleton();
		System.out.println("The first reference: " + s2);
		System.out.println("The first data: " + s2.getData());
	}

	/* Lazy singleton example */
	@Test
	public void getSynchSingletonTest() {
		SynchSingleton s1 = idp.getSynchSingleton();
		s1.setData(55);
		System.out.println("The first reference: " + s1);
		System.out.println("The first data: " + s1.getData());

		System.out.println("-------X--------------X--------");
		s1 = null;
		SynchSingleton s2 = idp.getSynchSingleton();
		System.out.println("The first reference: " + s2);
		System.out.println("The first data: " + s2.getData());
	}

	/* Double locked singleton example */
	@Test
	public void getDoubleLockSingletonTest() {
		DoubleLockSingleton s1 = idp.getDoubleLockSingleton();
		s1.setData(55);
		System.out.println("The first reference: " + s1);
		System.out.println("The first data: " + s1.getData());

		System.out.println("-------X--------------X--------");
		s1 = null;
		DoubleLockSingleton s2 = idp.getDoubleLockSingleton();
		System.out.println("The first reference: " + s2);
		System.out.println("The first data: " + s2.getData());
	}

	/* Eager singleton example */
	@Test
	public void getEagerSingletonTest() {
		EagerSingleton s1 = idp.getEagerSingleton();
		s1.setData(55);
		System.out.println("The first reference: " + s1);
		System.out.println("The first data: " + s1.getData());

		System.out.println("-------X--------------X--------");
		s1 = null;
		EagerSingleton s2 = idp.getEagerSingleton();
		System.out.println("The first reference: " + s2);
		System.out.println("The first data: " + s2.getData());
	}

	/* Bill Pugh singleton example */
	@Test
	public void getBillPughSingletonTest() {
		BillPughSingleton s1 = idp.getBillPughSingleton();
		s1.setData(55);
		System.out.println("The first reference: " + s1);
		System.out.println("The first data: " + s1.getData());

		System.out.println("-------X--------------X--------");
		s1 = null;
		BillPughSingleton s2 = idp.getBillPughSingleton();
		System.out.println("The first reference: " + s2);
		System.out.println("The first data: " + s2.getData());
	}

	/* Caption singleton example */
	@Test
	public void getCaptionTest() {
		Caption s1 = idp.getCaption();

		System.out.println("The first reference: " + s1);
		System.out.println("The first data: " + s1.getName());

		System.out.println("-------X--------------X--------");
		s1 = null;
		Caption s2 = idp.getCaption();
		System.out.println("The first reference: " + s2);
		System.out.println("The first data: " + s2.getName());
	}

	/** Builder Design Pattern */

	/* Builder pattern Example demo */
	@Test
	public void builderPatternTest() {
		IVehicleBuilder car = new Car();
		IVehicleBuilder motorCycle = new MotorCycle();
		idp.builderPattern(car);
		System.out.println("\n-----------XX----------------XX---------");
		idp.builderPattern(motorCycle);
	}

	/* Builder pattern Example challenge */
	@Test
	public void builderPatternChallenge() {

		IMealBuilder vegMealBuilder = new VegMealBuilder();
		System.out.println("Veg Meals:");
		idp.builderPatternChallenge(vegMealBuilder);
		System.out.println("\n-----------XX----------------XX---------\n");
		System.out.println("Non-Veg Meals:");
		IMealBuilder nonVegMealBuilder = new NonVegMealBuilder();
		idp.builderPatternChallenge(nonVegMealBuilder);
	}

	/** Prototype design pattern */
	/* Prototype example */
	@Test
	public void protoTypeExmpleTest() {
		idp.protoTypeExmple();
	}

	/* Prototype challenge */
	@Test
	public void protoTypeChallengeTest() {
		idp.protoTypeChallenge();
	}

}
