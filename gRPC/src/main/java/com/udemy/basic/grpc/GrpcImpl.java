package com.udemy.basic.grpc;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import com.grpc.game.Die;
import com.grpc.game.GameServiceGrpc;
import com.grpc.game.GameServiceGrpc.GameServiceStub;
import com.udemy.basic.grpc.client.loadbalancing.NginxClient;
import com.udemy.basic.grpc.client.rpctypes.BalanceStreamObserver;
import com.udemy.basic.grpc.client.rpctypes.MoneyStreamingResponse;
import com.udemy.basic.grpc.client.rpctypes.TransferStreamingResponse;
import com.udemy.basic.grpc.game.client.GameStateStreamingResponse;
import com.udemy.basic.grpc.server.rpctypes.GrpcServer;
import com.udemy.proto.Balance;
import com.udemy.proto.BalanceCheckRequest;
import com.udemy.proto.BankServiceGrpc;
import com.udemy.proto.BankServiceGrpc.BankServiceBlockingStub;
import com.udemy.proto.BankServiceGrpc.BankServiceStub;
import com.udemy.proto.DepositeRequest;
import com.udemy.proto.Money;
import com.udemy.proto.TransferRequest;
import com.udemy.proto.TransferServiceGrpc;
import com.udemy.proto.TransferServiceGrpc.TransferServiceStub;
import com.udemy.proto.WithdrawRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GrpcImpl implements IGrpc {

	/**
	 * create Grpc Server
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void createGrpcServer() throws IOException, InterruptedException {

		GrpcServer.startGrpcServer();
	}

	/** building client for accessing server */
	@Override
	public BankServiceBlockingStub createGrpcClient() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
		        .usePlaintext()
		        .build();

		return BankServiceGrpc.newBlockingStub(channel);
	}

	/** building Async client for accessing server */
	public BankServiceStub createGrpcClientAsync() {

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
		        .usePlaintext()
		        .build();

		return BankServiceGrpc.newStub(channel);
	}

	/** building Async client for accessing server */
	public GameServiceStub createGrpcGameClientAsync() {

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
		        .usePlaintext()
		        .build();

		return GameServiceGrpc.newStub(channel);
	}

	/** get balance from server */
	@Override
	public Integer getBalanceUnary(int accountId) {
		BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
		        .setAccountNumber(accountId)
		        .build();
		Balance balance = createGrpcClient().getBalance(balanceCheckRequest);
		return balance.getAmount();
	}

	/** get balance streaming */
	@Override
	public void getBalanceStreaming(int accountId, int amount) {
		WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder()
		        .setAccountNumber(accountId)
		        .setAmount(amount)
		        .build();
		Iterator<Money> money = createGrpcClient().withdraw(withdrawRequest);
		while (money.hasNext()) {
			System.out.println(money.next()
			        .getValue());
		}
	}

	/** Server Streaming Async Client */
	@Override
	public void getBalanceStreamingAsync(int accountId, int amount) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder()
		        .setAccountNumber(accountId)
		        .setAmount(amount)
		        .build();
		createGrpcClientAsync().withdraw(withdrawRequest, new MoneyStreamingResponse(latch));

		latch.await();
		// using below is not good so CountDownLatch
		// Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	/** Client streaming Request */
	@Override
	public void getBalanceClientStreaming(int accountId, int amount) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		StreamObserver<DepositeRequest> streamObserver = createGrpcClientAsync()
		        .cashDeposite(new BalanceStreamObserver(latch));

		for (int i = 0; i < 10; i++) {
			DepositeRequest depositeRequest = DepositeRequest.newBuilder()
			        .setAccountNumber(accountId)
			        .setAmount(amount)
			        .build();
			streamObserver.onNext(depositeRequest);
		}
		streamObserver.onCompleted();

		latch.await();

	}

	/** building Async client for accessing server for transfer service */
	@Override
	public TransferServiceStub createClientforTransfer() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
		        .usePlaintext()
		        .build();

		return TransferServiceGrpc.newStub(channel);
	}

	/**
	 * Bi directional streaming transfer
	 * 
	 * @throws InterruptedException
	 */
	@Override
	public void bidirectionalStreamingTransfer() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		TransferStreamingResponse response = new TransferStreamingResponse(latch);
		StreamObserver<TransferRequest> requestStreamObserver = this.createClientforTransfer()
		        .transfer(response);

		for (int i = 0; i < 100; i++) {
			TransferRequest transferRequest = TransferRequest.newBuilder()
			        .setFromAccount(ThreadLocalRandom.current()
			                .nextInt(1, 11))
			        .setToAccount(ThreadLocalRandom.current()
			                .nextInt(1, 11))
			        .setAmount(ThreadLocalRandom.current()
			                .nextInt(1, 21))
			        .build();
			requestStreamObserver.onNext(transferRequest);
		}
		requestStreamObserver.onCompleted();
		latch.await();
	}

	/** Snack ladder game */
	public void snacksLaderGame() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		GameStateStreamingResponse gameStateStreamingResponse = new GameStateStreamingResponse(latch);
		StreamObserver<Die> dieStreamObserver = createGrpcGameClientAsync().roll(gameStateStreamingResponse);
		gameStateStreamingResponse.setDieStreamObserver(dieStreamObserver);
		gameStateStreamingResponse.roll();
		latch.await();
	}

	/** server load balancing test */
	public void serverLoadbalancing() throws InterruptedException {
		for (int i = 0; i < 11; i++) {
			BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
			        .setAccountNumber(7)
			        .build();
			Balance balance = NginxClient.createGrpcClient()
			        .getBalance(balanceCheckRequest);
			System.out.println("Recievved:  -" + balance.getAmount());
		}
	}
	
	/** server load balancing streaing test */
	public void serverLoadbalancingStreaming() throws InterruptedException{
		CountDownLatch latch = new CountDownLatch(1);
		StreamObserver<DepositeRequest> streamObserver = NginxClient.createGrpcClientStreaming()
		        .cashDeposite(new BalanceStreamObserver(latch));

		for (int i = 0; i < 10; i++) {
			DepositeRequest depositeRequest = DepositeRequest.newBuilder()
			        .setAccountNumber(8)
			        .setAmount(10)
			        .build();
			streamObserver.onNext(depositeRequest);
		}
		streamObserver.onCompleted();

		latch.await();
	}
}
