package com.udemy.basic.dp.creational;

import com.udemy.basic.dp.creational.builder.IVehicleBuilder;
import com.udemy.basic.dp.creational.builder.challenge.IMealBuilder;
import com.udemy.basic.dp.creational.factory.abstr.creator.Shape;
import com.udemy.basic.dp.creational.factory.challenge.IAnimal;
import com.udemy.basic.dp.creational.singleton.BillPughSingleton;
import com.udemy.basic.dp.creational.singleton.Caption;
import com.udemy.basic.dp.creational.singleton.DoubleLockSingleton;
import com.udemy.basic.dp.creational.singleton.EagerSingleton;
import com.udemy.basic.dp.creational.singleton.LazySingleton;
import com.udemy.basic.dp.creational.singleton.SynchSingleton;

public interface ICreationalDp {

	/** Factory Design Pattern **/

	/* Factory pattern : abstract creator */
	public void factoryAbstractCreator(Shape s);

	/* Factory pattern : concrete creator */
	public void factoryConcreteCreator(Shape s);

	/* Factory pattern : Static creator */
	public void factoryStaticCreator(Shape s);

	/* challenge task for use create/use factory */
	public void factoryChallenge(IAnimal iAnimal);

	/** Abstract Factory design pattern **/
	public void abstractFactoryExmaple(String choice, String type);

	/* Abstract Factory design pattern Challenge */
	/* first approach */
	public void absractFactoryChallengeX(String choice);

	/* second approach */
	public void absractFactoryChallengeY(String type);

	/** Singleton Design pattern */

	/* Lazy singleton example */
	public LazySingleton getLazySingleton();

	/* Lazy singleton example */
	public SynchSingleton getSynchSingleton();

	/* Double locked singleton example */
	public DoubleLockSingleton getDoubleLockSingleton();

	/* Eager singleton example */
	public EagerSingleton getEagerSingleton();

	/* Bill Pugh singleton example */
	public BillPughSingleton getBillPughSingleton();

	/* Challenge singleton example */
	public Caption getCaption();

	/** Builder Design Pattern */

	/* Builder pattern Example demo */
	public void builderPattern(IVehicleBuilder builder);

	/* Builder pattern Example challenge */
	public void builderPatternChallenge(IMealBuilder builder);

	/** Prototype design pattern */

	/* Prototype example */
	public void protoTypeExmple();

	/* Prototype challenge */
	public void protoTypeChallenge();

}
