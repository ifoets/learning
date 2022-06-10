package com.udemy.basic.grpc;

import java.io.IOException;

import com.udemy.proto.BankServiceGrpc.BankServiceBlockingStub;
import com.udemy.proto.BankServiceGrpc.BankServiceStub;
import com.udemy.proto.TransferServiceGrpc.TransferServiceStub;

public interface IGrpc {

	/** building Grpc Server */
	public void createGrpcServer() throws IOException, InterruptedException;

	/** building client for accessing server */
	public BankServiceBlockingStub createGrpcClient();

	/** building Async client for accessing server */
	public BankServiceStub createGrpcClientAsync();

	/** get balance from unary */
	public Integer getBalanceUnary(int accountId);

	/** get balance streaming */
	public void getBalanceStreaming(int accountId, int amount) throws InterruptedException;

	/** Server Streaming Async Client */
	public void getBalanceStreamingAsync(int accountId, int amount) throws InterruptedException;

	/** Client streaming Request */
	public void getBalanceClientStreaming(int accountId, int amount) throws InterruptedException;

	/** building Async client for accessing server for transfer service */
	public TransferServiceStub createClientforTransfer();

	/** Bi directional streaming transfer */
	public void bidirectionalStreamingTransfer() throws InterruptedException;

	/** Snack ladder game */
	public void snacksLaderGame() throws InterruptedException;

	/** server load balancing test */
	public void serverLoadbalancing() throws InterruptedException;
	
	/** server load balancing streaing test */
	public void serverLoadbalancingStreaming() throws InterruptedException;

}
