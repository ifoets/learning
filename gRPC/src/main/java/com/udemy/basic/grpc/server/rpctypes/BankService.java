package com.udemy.basic.grpc.server.rpctypes;

import com.udemy.proto.Balance;
import com.udemy.proto.BalanceCheckRequest;
import com.udemy.proto.DepositeRequest;
import com.udemy.proto.Money;
import com.udemy.proto.WithdrawRequest;
import com.udemy.proto.BankServiceGrpc.BankServiceImplBase;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceImplBase {

	@Override
	public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {

		int accountNumber = request.getAccountNumber();
		Balance balance = Balance.newBuilder()
		        .setAmount(AccountDatabse.getBalance(accountNumber))
		        .build();

		responseObserver.onNext(balance);
		// below cant do/repeat unray call send only one response
		// responseObserver.onNext(balance);
		responseObserver.onCompleted();
	}

	@Override
	public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
		int accountNumber = request.getAccountNumber();
		int amount = request.getAmount();
		int balance = AccountDatabse.getBalance(accountNumber);

		if (balance < amount) {
			Status status = Status.FAILED_PRECONDITION.withDescription("No Enough money. You have only " + balance);
			responseObserver.onError(status.asRuntimeException());
			return;
		}

		for (int i = 0; i < (amount / 10); i++) {
			Money money = Money.newBuilder()
			        .setValue(10)
			        .build();
			responseObserver.onNext(money);
			AccountDatabse.deductBalance(accountNumber, 10);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<DepositeRequest> cashDeposite(StreamObserver<Balance> responseObserver) {
		return new CashStreamingRequest(responseObserver);
	}

}
