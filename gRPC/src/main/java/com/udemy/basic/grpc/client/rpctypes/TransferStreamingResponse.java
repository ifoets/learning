package com.udemy.basic.grpc.client.rpctypes;

import java.util.concurrent.CountDownLatch;

import com.udemy.proto.TransferResponse;

import io.grpc.stub.StreamObserver;

public class TransferStreamingResponse implements StreamObserver<TransferResponse> {

	CountDownLatch latch;

	public TransferStreamingResponse(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void onNext(TransferResponse transferResponse) {

		System.out.println("Status : " + transferResponse.getStatus());
		transferResponse.getAccountsList()
		        .stream()
		        .map(account -> account.getAccountNumber() + " : " + account.getAmount())
		        .forEach(System.out::println);
		System.out.println("--------X--------------------------X---------");
	}

	@Override
	public void onError(Throwable t) {
		this.latch.countDown();
	}

	@Override
	public void onCompleted() {
		System.out.println("All transfer done !!");
		this.latch.countDown();
	}

}
