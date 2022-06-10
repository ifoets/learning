package com.udemy.basic.grpc.client.rpctypes;

import java.util.concurrent.CountDownLatch;

import com.udemy.proto.Money;

import io.grpc.stub.StreamObserver;

public class MoneyStreamingResponse implements StreamObserver<Money> {

	CountDownLatch latch;

	public MoneyStreamingResponse(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void onNext(Money value) {
		System.out.println("Received Aync Value : " + value.getValue());

	}

	@Override
	public void onError(Throwable t) {
		System.out.println(t.getMessage());
		latch.countDown();
	}

	@Override
	public void onCompleted() {
		System.out.println("Done !!!");
		latch.countDown();

	}

}
