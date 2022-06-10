package com.udemy.basic.grpc.client.rpctypes;

import java.util.concurrent.CountDownLatch;

import com.udemy.proto.Balance;

import io.grpc.stub.StreamObserver;

public class BalanceStreamObserver implements StreamObserver<Balance> {

	private CountDownLatch latch;

	public BalanceStreamObserver(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void onNext(Balance value) {
		System.out.println("Final Balance :" + value.getAmount());

	}

	@Override
	public void onError(Throwable t) {
		latch.countDown();
	}

	@Override
	public void onCompleted() {
		System.out.println("Server is Done !!");
		latch.countDown();
	}

}
