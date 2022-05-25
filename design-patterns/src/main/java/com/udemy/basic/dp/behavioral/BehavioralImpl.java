package com.udemy.basic.dp.behavioral;

import com.udemy.basic.dp.behavioral.chainof.respo.challenge.Error;
import com.udemy.basic.dp.behavioral.chainof.respo.challenge.IssueRaiser;
import com.udemy.basic.dp.behavioral.chainof.respo.challenge.MessagePriority;
import com.udemy.basic.dp.behavioral.chainof.responsibility.AtmDispencer;
import com.udemy.basic.dp.behavioral.chainof.responsibility.Currency;
import com.udemy.basic.dp.behavioral.command.FileInvoker;
import com.udemy.basic.dp.behavioral.command.challenge.Broker;
import com.udemy.basic.dp.behavioral.command.challenge.command.BuyStock;
import com.udemy.basic.dp.behavioral.command.challenge.command.SellStock;
import com.udemy.basic.dp.behavioral.command.challenge.receiver.Stock;
import com.udemy.basic.dp.behavioral.command.command.CloseFileCommand;
import com.udemy.basic.dp.behavioral.command.command.OpenFileCommand;
import com.udemy.basic.dp.behavioral.command.command.WriteFileCommand;
import com.udemy.basic.dp.behavioral.command.receiver.FileSystemReceiver;
import com.udemy.basic.dp.behavioral.command.receiver.FileSystemReceiverUtil;
import com.udemy.basic.dp.behavioral.interpreter.InterpreterClient;
import com.udemy.basic.dp.behavioral.interpreter.InterpreterContext;
import com.udemy.basic.dp.behavioral.interpreter.challenge.Context;
import com.udemy.basic.dp.behavioral.interpreter.challenge.Expression;
import com.udemy.basic.dp.behavioral.iterator.NotificationBar;
import com.udemy.basic.dp.behavioral.iterator.NotificationCollection;
import com.udemy.basic.dp.behavioral.iterator.challenge.Arts;
import com.udemy.basic.dp.behavioral.iterator.challenge.Science;
import com.udemy.basic.dp.behavioral.iterator.challenge.StudentsClient;
import com.udemy.basic.dp.behavioral.iterator.challenge.StudentsIterator;
import com.udemy.basic.dp.behavioral.iterator.challenge.SubjectInterface;
import com.udemy.basic.dp.behavioral.mediator.ChatMediator;
import com.udemy.basic.dp.behavioral.mediator.ChatMediatorImpl;
import com.udemy.basic.dp.behavioral.mediator.User;
import com.udemy.basic.dp.behavioral.mediator.UserImpl;
import com.udemy.basic.dp.behavioral.mediator.challenge.AuctionMediator;
import com.udemy.basic.dp.behavioral.mediator.challenge.AuctionMediatorImpl;
import com.udemy.basic.dp.behavioral.mediator.challenge.Buyer;
import com.udemy.basic.dp.behavioral.mediator.challenge.BuyerImpl;

public class BehavioralImpl implements IBehaviroal {

	/** Chain of Responsibility Design Pattern **/

	/* Chain of Responsibility Design Pattern Example **/
	@Override
	public void chainOfResponsibilityExmpl() {
		Currency currency = new Currency(1380);
		AtmDispencer atmDispencer = new AtmDispencer();
		atmDispencer.c1.dispense(currency);
	}

	/* Chain of Responsibility Design Pattern Challenge **/
	@Override
	public void chainOfResponsibilityChallenge() {
		Error error1 = new Error("Fax", MessagePriority.NORMAL, "Fax error 1324");
		Error error2 = new Error("Email", MessagePriority.HIGH, "Email error 432");

		IssueRaiser issueRaiser = new IssueRaiser();
		issueRaiser.raiseMessage(error1.getMessage());
		issueRaiser.raiseMessage(error2.getMessage());
	}

	/** Command design pattern */

	/* Command design pattern examples */
	@Override
	public void commandPatterExample() {
		// creating the receiver
		FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

		// create the command with the associating receiver
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);

		// creating invoker and associate it with the command
		FileInvoker file = new FileInvoker(openFileCommand);

		// perform action on invoker object
		file.execute();

		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		file = new FileInvoker(writeFileCommand);
		file.execute();

		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		file = new FileInvoker(closeFileCommand);
		file.execute();
	}

	/* Command design pattern Challenge */
	@Override
	public void commandPatterChallenge() {
		Stock googleStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(googleStock);
		SellStock sellStockOrder = new SellStock(googleStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
		broker.placeOrders();
	}

	/* Interpreter design pattern Example */
	@Override
	public void interpreterPatternExampl() {
		String str1 = "28 in Binary";
		String str2 = "28 in Hexadecimal";

		InterpreterClient ec = new InterpreterClient(new InterpreterContext());
		System.out.println(str1 + " = " + ec.interpreter(str1));
		System.out.println(str2 + " = " + ec.interpreter(str2));
	}

	/* Interpreter design pattern Challenge */
	@Override
	public void interpreterPatternChallenge() {
		Expression isMale = com.udemy.basic.dp.behavioral.interpreter.challenge.InterpreterClient.getMaleExpression();
		Expression isMarriedWoman = com.udemy.basic.dp.behavioral.interpreter.challenge.InterpreterClient
		        .getMarriedWomanExpression();

		Context ic = new Context("John");
		System.out.println("John is male? " + isMale.interpret(ic));

		Context ic2 = new Context("Married Julie");
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret(ic2));

		Context ic3 = new Context("Married Lucy");
		System.out.println("Lucy is male? " + isMale.interpret(ic3));
	}

	/** Iterator design pattern */

	/* Iterator design pattern Example */
	@Override
	public void interatorPatternExample() {
		NotificationCollection nc = new NotificationCollection();
		NotificationBar nb = new NotificationBar(nc);

		nb.printNotifications();
	}

	/* Iterator design pattern Challenge */
	@Override
	public void interatorPatternChallege() {
		System.out.println("******** Iterator Pattern Demo ********\n");

		SubjectInterface s = new Science();
		SubjectInterface a = new Arts();

		StudentsIterator scIterator = s.createIterator();
		StudentsIterator aIterator = a.createIterator();

		StudentsClient.print(scIterator);
		StudentsClient.print(aIterator);
	}

	/** Mediator design pattern */

	/* Mediator design pattern Example */
	@Override
	public void mediatorPatternExample() {
		ChatMediator mediator = new ChatMediatorImpl();

		User user1 = new UserImpl(mediator, "John");
		User user2 = new UserImpl(mediator, "Jennifer");
		User user3 = new UserImpl(mediator, "Lucy");
		User user4 = new UserImpl(mediator, "Ian");

		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);

		user1.send("Hi All");
	}

	/* Mediator design pattern Challenge */
	@Override
	public void mediatorPatternChallenge() {
		AuctionMediator mediator = new AuctionMediatorImpl();

		Buyer buyer1 = new BuyerImpl(mediator, "Jason");
		Buyer buyer2 = new BuyerImpl(mediator, "John");
		Buyer buyer3 = new BuyerImpl(mediator, "Jennifer");
		Buyer buyer4 = new BuyerImpl(mediator, "Lucy");

		mediator.addBuyer(buyer1);
		mediator.addBuyer(buyer2);
		mediator.addBuyer(buyer3);
		mediator.addBuyer(buyer4);

		buyer1.bid(100);
		buyer2.bid(120);
		buyer3.bid(130);
		buyer4.bid(140);

		mediator.findHighestBidder();

		buyer4.cancelBid();

		mediator.findHighestBidder();
	}
}
