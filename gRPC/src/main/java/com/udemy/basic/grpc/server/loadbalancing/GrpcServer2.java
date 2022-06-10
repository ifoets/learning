package com.udemy.basic.grpc.server.loadbalancing;

import java.io.IOException;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer2 {

	public static void main(String[] args)  throws IOException, InterruptedException {
		startGrpcLoadbalancingServer();
	}
	public static void startGrpcLoadbalancingServer() throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(7575)
		        .addService((BindableService) new BankService())
		        .build();
		server.start();
		System.out.println("Server is stated on port: 7575");
		server.awaitTermination();
	}
}
