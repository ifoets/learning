package com.udemy.basic.dp.structural;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;

import com.udemy.basic.dp.structural.adapter.challenge.AdvanceMediaPlayerAdapter;
import com.udemy.basic.dp.structural.adapter.challenge.AudioPlayer;
import com.udemy.basic.dp.structural.adapter.challenge.IAdvanceMediaPlayer;
import com.udemy.basic.dp.structural.adapter.challenge.IMediaPlayer;
import com.udemy.basic.dp.structural.adapter.challenge.Mp4AdvanceMediaPlayer;
import com.udemy.basic.dp.structural.adapter.challenge.VlcAdvanceMediaPlayer;
import com.udemy.basic.dp.structural.adapter.cls.ex1.ClassAdapter;
import com.udemy.basic.dp.structural.adapter.cls.ex1.IIntValue;
import com.udemy.basic.dp.structural.adapter.cls.ex1.IntValue;
import com.udemy.basic.dp.structural.adapter.cls.ex1.ObjectAdapter;
import com.udemy.basic.dp.structural.adapter.obj.ex1.MallardDuck;
import com.udemy.basic.dp.structural.adapter.obj.ex1.TurkeyAdapter;
import com.udemy.basic.dp.structural.adapter.obj.ex1.WildTurkey;
import com.udemy.basic.dp.structural.adapter.obj.ex2.CalculatorAdapter;
import com.udemy.basic.dp.structural.adapter.obj.ex2.Rectangle;
import com.udemy.basic.dp.structural.adapter.obj.ex2.Triangle;
import com.udemy.basic.dp.structural.bridge.Assembled;
import com.udemy.basic.dp.structural.bridge.Bike;
import com.udemy.basic.dp.structural.bridge.Car;
import com.udemy.basic.dp.structural.bridge.Produced;
import com.udemy.basic.dp.structural.bridge.Vehicle;
import com.udemy.basic.dp.structural.bridge.challenge.GreenColor;
import com.udemy.basic.dp.structural.bridge.challenge.RedColor;
import com.udemy.basic.dp.structural.bridge.challenge.Tringle;
import com.udemy.basic.dp.structural.composite.Developer;
import com.udemy.basic.dp.structural.composite.Director;
import com.udemy.basic.dp.structural.composite.Directory;
import com.udemy.basic.dp.structural.composite.Manager;
import com.udemy.basic.dp.structural.composite.challenge.Professor;
import com.udemy.basic.dp.structural.composite.challenge.Supervisor;
import com.udemy.basic.dp.structural.decorator.Component;
import com.udemy.basic.dp.structural.decorator.ConcreateComponent;
import com.udemy.basic.dp.structural.decorator.ConcreateDecoratorEx1;
import com.udemy.basic.dp.structural.decorator.ConcreateDecoratorEx2;
import com.udemy.basic.dp.structural.decorator.challenge.DecoCircle;
import com.udemy.basic.dp.structural.decorator.challenge.DecoRectangle;
import com.udemy.basic.dp.structural.decorator.challenge.GreenShapeDecorator;
import com.udemy.basic.dp.structural.decorator.challenge.IDecoShape;
import com.udemy.basic.dp.structural.decorator.challenge.RedShapeDecorator;
import com.udemy.basic.dp.structural.decorator.file.ex.LowerCaseInputStream;
import com.udemy.basic.dp.structural.facade.Amplifier;
import com.udemy.basic.dp.structural.facade.CdPlayer;
import com.udemy.basic.dp.structural.facade.DvdPlayer;
import com.udemy.basic.dp.structural.facade.HomeTheaterFacade;
import com.udemy.basic.dp.structural.facade.PopcornPopper;
import com.udemy.basic.dp.structural.facade.Projector;
import com.udemy.basic.dp.structural.facade.Screen;
import com.udemy.basic.dp.structural.facade.TheaterLights;
import com.udemy.basic.dp.structural.facade.Tuner;
import com.udemy.basic.dp.structural.facade.challenge.HotelKeeper;
import com.udemy.basic.dp.structural.facade.challenge.Menus;
import com.udemy.basic.dp.structural.flyweight.RobotFactory;
import com.udemy.basic.dp.structural.flyweight.RobotInterface;
import com.udemy.basic.dp.structural.flyweight.RobotType;
import com.udemy.basic.dp.structural.flyweight.challenge.Player;
import com.udemy.basic.dp.structural.flyweight.challenge.PlayerFactory;
import com.udemy.basic.dp.structural.flyweight.challenge.PlayerType;
import com.udemy.basic.dp.structural.flyweight.challenge.WeaponType;
import com.udemy.basic.dp.structural.proxy.ProxyImage;
import com.udemy.basic.dp.structural.proxy.challenge.ProxyConnector;

public class StructuralDpImpl implements IStructuralDp {

	/** Adapter design pattern */

	/*
	 * Object Adapter by Composition, Turkey/Duck Example, Turkey behaves like Duck
	 */
	public void adapterByCompositionEx1() {

		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();
		TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);

		System.out.println("Turkey Saying....\n");
		turkey.gobble();
		turkey.fly();

		System.out.println("-----X-----------X--------");
		System.out.println("Duck Saying.....\n");
		duck.quack();
		duck.fly();

		System.out.println("-----X-----------X--------");
		System.out.println("Turkey Adapter Saying.....\n");
		turkeyAdapter.quack();
		turkeyAdapter.fly();
	}

	/*
	 * Object Adapter by Composition, Calculator/Rectangle/Triangle, calculating
	 * area of triangle using area calculator of Rectangle
	 */
	@Override
	public void adapterByCompositionEx2() {
		Triangle t = new Triangle(100, 200);

		CalculatorAdapter calAdp = new CalculatorAdapter(t);
		System.out.println("Area of Triangle 100,200 ::" + calAdp.getArea(new Rectangle(1, 2)));
	}

	/* by using object composition */
	@Override
	public void adapterByObjectComp() {
		IIntValue iintval = new IntValue();
		ObjectAdapter objAdp = new ObjectAdapter(iintval);
		System.out.println("Value of Intger by Object Composition Adapter: " + objAdp.getIntValue());
	}

	/* by using interface implementation */
	@Override
	public void adapterByInterfaceImpl() {
		ClassAdapter objAdp = new ClassAdapter();
		System.out.println("Value of Intger by Interface implementation Adapter: " + objAdp.getIntValue());
	}

	/* by using composition implementation challenge */
	@Override
	public void adapterByCompositionChallenge() {
		IMediaPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "jasonMusic.mp3");

		IAdvanceMediaPlayer vlc = new VlcAdvanceMediaPlayer();
		AdvanceMediaPlayerAdapter adp1 = new AdvanceMediaPlayerAdapter(vlc);
		adp1.play("vlc", "far far away.vlc");

		IAdvanceMediaPlayer mp4 = new Mp4AdvanceMediaPlayer();
		AdvanceMediaPlayerAdapter adp2 = new AdvanceMediaPlayerAdapter(mp4);
		adp2.play("mp4", "alone.mp4");

		audioPlayer.play("vlc", "far far away.vlc");
	}

	/** Bridge design pattern **/

	/* Bridge design pattern Example */
	@Override
	public void bridgePatternExample() {
		Vehicle veh1 = new Car(new Produced(), new Assembled());
		veh1.manufacture();

		Vehicle veh2 = new Bike(new Produced(), new Assembled());
		veh2.manufacture();
	}

	/* Bridge design pattern Challenge */
	@Override
	public void bridgePatternChallenge() {
		Tringle tr = new Tringle(new GreenColor());
		tr.drawShapes(20);
		System.out.println("Modifing border 3 times");
		tr.modifyBorder(20, 3);

		com.udemy.basic.dp.structural.bridge.challenge.Rectangle rect = new com.udemy.basic.dp.structural.bridge.challenge.Rectangle(
		        new RedColor());
		rect.drawShapes(50);
		System.out.println("Modifing border 2 times");
		rect.modifyBorder(50, 2);

	}

	/* Composite design pattern example */
	public void compositePatternExampleX() {
		Developer dev1 = new Developer("Abhimanyu", 100, "Sen Devloper");
		Developer dev2 = new Developer("Kumar", 201, "Fresher Devloper");

		Directory engDir = new Directory();
		engDir.addEmployee(dev1);
		engDir.addEmployee(dev2);

		Manager man1 = new Manager("Raj", 300, "Dev Manager");
		Manager man2 = new Manager("Kumar Raj", 401, "UI Manager");

		Directory accDir = new Directory();
		accDir.addEmployee(man1);
		accDir.addEmployee(man2);

		Directory comDir = new Directory();
		comDir.addEmployee(engDir);
		comDir.addEmployee(accDir);

		comDir.showEmplyoeeDetails();
	}

	/* Composite design pattern exampleX */
	@Override
	public void compositePatternExampleY() {
		Developer dev1 = new Developer("Abhimanyu", 100, "Sen Devloper");
		Developer dev2 = new Developer("Kumar", 201, "Fresher Devloper");

		Directory engDir = new Directory();
		engDir.addEmployee(dev1);
		engDir.addEmployee(dev2);

		Manager man1 = new Manager("Raj", 300, "Dev Manager");
		Manager man2 = new Manager("Kumar Raj", 401, "UI Manager");

		Directory accDir = new Directory();
		accDir.addEmployee(man1);
		accDir.addEmployee(man2);

		Director director = new Director("Swamiji", 10000000.0);
		director.addEmployee(engDir);
		director.addEmployee(accDir);

		director.showEmplyoeeDetails();
	}

	/* Composite design pattern Challenge */
	@Override
	public void compositePatternChallenge() {
		Supervisor technologyDean = new Supervisor("Dr. Mike", "Dean of Technology");
		Supervisor charOfMathoDept = new Supervisor("Dr. John", "Chair of Math Department");
		Supervisor chairOfComputerScienceDept = new Supervisor("Dr. ian", "Char of Computer science Department");

		Professor mathProf1 = new Professor("Math Professor1", "Adjunct", 301);
		Professor mathProf2 = new Professor("Math Professor2", "Associate", 302);

		Professor cseProf1 = new Professor("CSE Professor1", "Adjunct", 304);
		Professor cseProf2 = new Professor("CSE Professor2", "Professor", 305);
		Professor cseProf3 = new Professor("CSE Professor3", "Professor", 306);

		charOfMathoDept.add(mathProf1);
		charOfMathoDept.add(mathProf2);

		chairOfComputerScienceDept.add(cseProf1);
		chairOfComputerScienceDept.add(cseProf2);
		chairOfComputerScienceDept.add(cseProf3);

		technologyDean.add(charOfMathoDept);
		technologyDean.add(chairOfComputerScienceDept);

		System.out.println("Factulty of Technology Center");
		technologyDean.showDetails();

		System.out.println("\nFactulty of Technology Center after removing CSE Professor2");
		chairOfComputerScienceDept.remove(cseProf2);
		technologyDean.showDetails();
	}

	/* Decorator design pattern example */
	@Override
	public void decoratorPatternExample() {
		Component com = new ConcreateComponent();

		System.out.println("Decorating ConcreateComponent Object cc with ConcreateDecortorEx1");
		ConcreateDecoratorEx1 deco_1 = new ConcreateDecoratorEx1();
		deco_1.setComponent(com);
		deco_1.doJob();

		System.out
		        .println("Decorating ConcreateComponent Object cc with ConcreateDecortorEx1 and ConcreateDecortorEx2");
		ConcreateDecoratorEx2 deco_2 = new ConcreateDecoratorEx2();
		deco_2.setComponent(deco_1); // adding result form deco_1
		deco_2.doJob();

	}

	/* Decorator design pattern example File IO */
	@Override
	public void decoratorPatternExamFileIo(String str) {
		int c;
		StringBuffer strBuff = new StringBuffer(str);
		byte[] bytes = strBuff.toString()
		        .getBytes();
		try {
			InputStream in = new LowerCaseInputStream(new ByteArrayInputStream(bytes));
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Decorator design pattern example File IO */
	@Override
	public void decoratorPatternChallenge() {

		IDecoShape circle = new DecoCircle();

		IDecoShape redCircle = new RedShapeDecorator(new DecoCircle());
		IDecoShape greenRectangle = new GreenShapeDecorator(new DecoRectangle());

		System.out.println("Circle With Norml Border");
		circle.draw();
		System.out.println("------X------------X----------");
		System.out.println("Circle with Red border");
		redCircle.draw();
		System.out.println("------X------------X----------");
		System.out.println("Rectangle with Green border");
		greenRectangle.draw();

	}

	/** Facade Design Pattern **/

	/* Facade design pattern example */
	@Override
	public void facadePatternExample() {
		Amplifier amplifier = new Amplifier("Amplifier");
		Tuner tuner = new Tuner("Tuner", amplifier);
		DvdPlayer dvd = new DvdPlayer("DvdPlayer", amplifier);
		CdPlayer cd = new CdPlayer("CdPlayer", amplifier);
		Projector projector = new Projector("Projector", dvd);
		TheaterLights theaterLights = new TheaterLights("TheaterLights");
		Screen screen = new Screen("Screen");
		PopcornPopper popcornPopper = new PopcornPopper("Popcorn popper");

		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, tuner, dvd, cd, projector, theaterLights,
		        screen, popcornPopper);

		homeTheaterFacade.watchMovie("Interview with the Vampire");
		homeTheaterFacade.endMovie();
	}

	/* Facade design pattern challenge */
	public void facadePatternChallenge() {
		HotelKeeper keeper = new HotelKeeper();

		Menus vegMenu = keeper.getVeganMenu();
		Menus nonVeganMenu = keeper.getNonVeganMenu();

		vegMenu.showMenu();
		nonVeganMenu.showMenu();
	}

	/** Flyweight design pattern */

	/* Flyweight design pattern Example */
	@Override
	public void flyWeightPatternExample() {
		RobotFactory robotFactory = new RobotFactory();
		RobotInterface robotOne = robotFactory.getRobot(RobotType.SMALL_ROBOT);
		RobotInterface robotTwo;

		robotOne.setColor("red");

		for (var i = 0; i < 3; i++) {
			robotOne = robotFactory.getRobot(RobotType.SMALL_ROBOT);
			robotOne.print();
			robotOne.setColor("blue");
		}

		for (var i = 0; i < 5; i++) {
			robotTwo = robotFactory.getRobot(RobotType.LARGE_ROBOT);
			robotTwo.setColor("green");
			robotTwo.print();
		}

		int numOfDistinctRobots = robotFactory.totalObjectsCreated();
		System.out.println("\nDistinct Robot objects created till now = " + numOfDistinctRobots);
	}

	/* Flyweight design pattern Challenge */
	@Override
	public void flyWeightPatternChallenge() {
		PlayerFactory playerFactory = new PlayerFactory();
		Player playerOne = playerFactory.getPlayer(PlayerType.TERRORIST);
		Player playerTwo = playerFactory.getPlayer(PlayerType.COUNTER_TERRORIST);

		playerOne.assignWeapon(WeaponType.PISTOL);
		playerTwo.assignWeapon(WeaponType.ASSAULT_RIFLE);

		playerOne.mission();
		playerTwo.mission();

		playerOne.assignWeapon(WeaponType.KNIFE);
		playerTwo.assignWeapon(WeaponType.PISTOL);

		playerOne.mission();
		playerTwo.mission();
	}

	/** Proxy design Pattern */

	/* Proxy design Pattern Example */
	@Override
	public void proxyPatternExample() {
		ProxyImage proxyImage = new ProxyImage("someFilename.jpg");
		proxyImage.display();

		System.out.println("*".repeat(50));
		proxyImage.display();
	}

	/* Proxy design Pattern Challenge */
	@Override
	public void proxyPatternChallenge() {
		ProxyConnector proxyConnector = new ProxyConnector();

		try {
			proxyConnector.connect("www.foo.com");
			proxyConnector.connect("www.bam.com");
		} catch (ConnectException e) {
			System.out.println(e.getMessage());
		}
	}
}
