package com.udemy.basic.grpc.server.rpctypes;

import com.udemy.proto.Balance;
import com.udemy.proto.DepositeRequest;

import io.grpc.stub.StreamObserver;

public class CashStreamingRequest implements StreamObserver<DepositeRequest> {

	private StreamObserver<Balance> streamObserver;
	private int accountBalance;

	public CashStreamingRequest(StreamObserver<Balance> streamObserver) {
		this.streamObserver = streamObserver;
	}

	@Override
	public void onNext(DepositeRequest depositeRequest) {

		int accountNumber = depositeRequest.getAccountNumber();
		int amount = depositeRequest.getAmount();
		this.accountBalance = AccountDatabse.addBalance(accountNumber, amount);
	}

	@Override
	public void onError(Throwable t) {

	}

	@Override
	public void onCompleted() {
		Balance balance = Balance.newBuilder()
		        .setAmount(this.accountBalance)
		        .build();
		streamObserver.onNext(balance);
		streamObserver.onCompleted();
	}

}
