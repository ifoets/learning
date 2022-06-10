package com.udemy.basic.grpc.client.loadbalancing;

import com.udemy.proto.BankServiceGrpc;
import com.udemy.proto.BankServiceGrpc.BankServiceBlockingStub;
import com.udemy.proto.BankServiceGrpc.BankServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NginxClient {

	public static BankServiceBlockingStub createGrpcClient() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8585)
		        .usePlaintext()
		        .build();

		return BankServiceGrpc.newBlockingStub(channel);
	}

	public static BankServiceStub createGrpcClientStreaming() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8585)
		        .usePlaintext()
		        .build();

		return BankServiceGrpc.newStub(channel);
	}
}
