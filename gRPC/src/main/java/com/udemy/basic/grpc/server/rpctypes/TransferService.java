package com.udemy.basic.grpc.server.rpctypes;

import com.udemy.proto.TransferRequest;
import com.udemy.proto.TransferResponse;
import com.udemy.proto.TransferServiceGrpc.TransferServiceImplBase;

import io.grpc.stub.StreamObserver;

public class TransferService extends TransferServiceImplBase {

	@Override
	public StreamObserver<TransferRequest> transfer(StreamObserver<TransferResponse> responseObserver) {
		return new TransferStreamingRequest(responseObserver);
	}
}
