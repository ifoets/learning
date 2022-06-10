package com.udemy.basic.grpc.server.rpctypes;

import com.udemy.proto.Account;
import com.udemy.proto.TransferRequest;
import com.udemy.proto.TransferResponse;
import com.udemy.proto.TransferStatus;

import io.grpc.stub.StreamObserver;

public class TransferStreamingRequest implements StreamObserver<TransferRequest> {

	private StreamObserver<TransferResponse> streamObserver;

	public TransferStreamingRequest(StreamObserver<TransferResponse> streamObserver) {
		this.streamObserver = streamObserver;

	}

	@Override
	public void onNext(TransferRequest transferRequest) {

		int fromAccount = transferRequest.getFromAccount();
		int toAccount = transferRequest.getToAccount();
		int amount = transferRequest.getAmount();
		int balance = AccountDatabse.getBalance(fromAccount);

		@SuppressWarnings("unused")
		TransferStatus status = TransferStatus.FAILED;
		if (amount < balance && fromAccount != toAccount) {
			AccountDatabse.deductBalance(fromAccount, amount);
			AccountDatabse.addBalance(toAccount, amount);
			status = TransferStatus.SUCCESS;
		}
		Account fromAccountInfo = Account.newBuilder()
		        .setAccountNumber(fromAccount)
		        .setAmount(AccountDatabse.getBalance(fromAccount))
		        .build();
		Account toAccountInfo = Account.newBuilder()
		        .setAccountNumber(toAccount)
		        .setAmount(AccountDatabse.getBalance(toAccount))
		        .build();
		TransferResponse transferResponse = TransferResponse.newBuilder()
		        .addAccounts(toAccountInfo)
		        .addAccounts(fromAccountInfo)
		        .setStatus(status)
		        .build();
		this.streamObserver.onNext(transferResponse);

	}

	@Override
	public void onError(Throwable t) {

	}

	@Override
	public void onCompleted() {
		AccountDatabse.printAccountDetails();
		this.streamObserver.onCompleted();

	}

}
