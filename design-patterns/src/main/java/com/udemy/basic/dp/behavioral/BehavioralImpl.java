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
}
