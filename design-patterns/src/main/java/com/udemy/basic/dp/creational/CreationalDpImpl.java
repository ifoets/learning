package com.udemy.basic.dp.creational;

import com.udemy.basic.dp.creational.abstractfactory.AbstractFactory;
import com.udemy.basic.dp.creational.abstractfactory.FactoryProducer;
import com.udemy.basic.dp.creational.abstractfactory.IColor;
import com.udemy.basic.dp.creational.abstractfactory.IShape;
import com.udemy.basic.dp.creational.abstractfactory.challenge.IBollywoodMovie;
import com.udemy.basic.dp.creational.abstractfactory.challenge.IHollywoodMovie;
import com.udemy.basic.dp.creational.abstractfactory.challenge.IIMoveFactory;
import com.udemy.basic.dp.creational.abstractfactory.challenge.IMoveFactory;
import com.udemy.basic.dp.creational.abstractfactory.challenge.MFactoryProducer;
import com.udemy.basic.dp.creational.abstractfactory.challenge.MovieFactoryProducer;
import com.udemy.basic.dp.creational.builder.Director;
import com.udemy.basic.dp.creational.builder.IVehicleBuilder;
import com.udemy.basic.dp.creational.builder.challenge.IMealBuilder;
import com.udemy.basic.dp.creational.builder.challenge.Meal;
import com.udemy.basic.dp.creational.builder.challenge.MealDirector;
import com.udemy.basic.dp.creational.factory.abstr.creator.Shape;
import com.udemy.basic.dp.creational.factory.challenge.IAnimal;
import com.udemy.basic.dp.creational.prototype.PShape;
import com.udemy.basic.dp.creational.prototype.PShapeCache;
import com.udemy.basic.dp.creational.prototype.challenge.BasicCar;
import com.udemy.basic.dp.creational.prototype.challenge.BasicCarCache;
import com.udemy.basic.dp.creational.prototype.challenge.Ford;
import com.udemy.basic.dp.creational.prototype.challenge.Nano;
import com.udemy.basic.dp.creational.singleton.BillPughSingleton;
import com.udemy.basic.dp.creational.singleton.Caption;
import com.udemy.basic.dp.creational.singleton.DoubleLockSingleton;
import com.udemy.basic.dp.creational.singleton.EagerSingleton;
import com.udemy.basic.dp.creational.singleton.LazySingleton;
import com.udemy.basic.dp.creational.singleton.SynchSingleton;

public class CreationalDpImpl implements ICreationalDp {

	/** Factory Design Pattern **/

	/* Factory pattern : abstract creator */
	@Override
	public void factoryAbstractCreator(Shape s) {
		s.draw();
	}

	/* Factory pattern : concrete creator */
	public void factoryConcreteCreator(Shape s) {
		s.draw();
	}

	/* Factory pattern : Static creator */
	public void factoryStaticCreator(Shape s) {
		s.draw();
	}

	/* challenge task for use create/use factory */
	public void factoryChallenge(IAnimal iAnimal) {
		iAnimal.walk();
	}

	/** Abstract Factory design pattern **/
	public void abstractFactoryExmaple(String choice, String type) {
		AbstractFactory absTractFactory = FactoryProducer.getFactory(choice);
		IColor color = absTractFactory.getColor(type);
		IShape shape = absTractFactory.getShape(type);

		if (color != null)
			color.fill();
		else if (shape != null)
			shape.draw();
	}

	/** Abstract Factory design pattern Challenge **/
	public void absractFactoryChallengeX(String choice) {

		IMoveFactory factory = MovieFactoryProducer.getFactory(choice);
		if (factory != null) {
			IHollywoodMovie hlm = factory.getHollywoodMovie();
			IBollywoodMovie blm = factory.getBollywoodMovie();
			if (choice.equalsIgnoreCase("Action")) {

				System.out.println("Action movies are...");
				System.out.println(hlm.getMovieName());
				System.out.println(blm.getMovieName());
			} else if (choice.equalsIgnoreCase("Comedy")) {

				System.out.println("Comedy movies are...");
				System.out.println(hlm.getMovieName());
				System.out.println(blm.getMovieName());
			}

		}
	}

	/* second approach */
	public void absractFactoryChallengeY(String type) {
		if (type.equalsIgnoreCase("bollywood")) {
			IIMoveFactory hfactory = MFactoryProducer.getFactory(type);
			System.out.println(hfactory.getBollywoodMovie("action")
			        .getMovieName());
			System.out.println(hfactory.getBollywoodMovie("comedy")
			        .getMovieName());
		} else if (type.equalsIgnoreCase("hollywood")) {
			IIMoveFactory hfactory = MFactoryProducer.getFactory(type);
			System.out.println(hfactory.getHollywoodMovie("action")
			        .getMovieName());
			System.out.println(hfactory.getHollywoodMovie("comedy")
			        .getMovieName());
		}
	}

	/** Singleton Design pattern */

	/* Lazy singleton example */
	public LazySingleton getLazySingleton() {
		return LazySingleton.getInstance();
	}

	/* Lazy singleton example */
	public SynchSingleton getSynchSingleton() {
		return SynchSingleton.getInstance();
	}

	/* Double locked singleton example */
	public DoubleLockSingleton getDoubleLockSingleton() {
		return DoubleLockSingleton.getInstance();
	}

	/* Eager singleton example */
	public EagerSingleton getEagerSingleton() {
		return EagerSingleton.getInstance();
	}

	/* Bill Pugh singleton example */
	@Override
	public BillPughSingleton getBillPughSingleton() {
		return BillPughSingleton.getInstance();
	}

	/* Caption singleton example */
	@Override
	public Caption getCaption() {
		return Caption.getInstance();
	}

	/** Builder Design Pattern */

	/* Builder pattern Example demo */
	public void builderPattern(IVehicleBuilder builder) {
		Director director = new Director();
		director.construct(builder);
		builder.getVehicle()
		        .show();
	}

	/* Builder pattern Example challenge */
	public void builderPatternChallenge(IMealBuilder builder) {
		MealDirector director = new MealDirector();

		director.construct(builder);
		Meal meal = builder.getMeal();
		meal.showItems();
		System.out.println(meal.getCost());
	}

	/** Prototype design pattern */
	/* Prototype example */
	public void protoTypeExmple() {
		PShapeCache.loadCache();

		PShape clonedShape1 = (PShape) PShapeCache.getShape("1");
		System.out.println("Shape: " + clonedShape1.getType());

		PShape clonedShape2 = (PShape) PShapeCache.getShape("2");
		System.out.println("Shape: " + clonedShape2.getType());

		PShape clonedShape3 = (PShape) PShapeCache.getShape("3");
		System.out.println("Shape: " + clonedShape3.getType());
	}

	/* Prototype challenge */
	public void protoTypeChallenge() {
		BasicCarCache.loadCache();

		BasicCar clonedCar1 = (BasicCar) BasicCarCache.getModel("Green Nano");
		Nano nano = (Nano) clonedCar1;
		nano.show();

		BasicCar clonedCar2 = (BasicCar) BasicCarCache.getModel("Yellow Ford");
		Ford ford = (Ford) clonedCar2;
		ford.show();
	}
}
