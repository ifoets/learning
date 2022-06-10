package com.udemy.basic.grpc.server.rpctypes;

import java.io.IOException;

import com.udemy.basic.grpc.game.server.GameService;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

	public static void startGrpcServer() throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(6565)
		        .addService((BindableService) new BankService())
		        .addService((BindableService) new TransferService())
		        .addService((BindableService) new GameService())
		        .build();
		server.start();
		System.out.println("Server is stated on port: 6565");
		server.awaitTermination();
	}
}
