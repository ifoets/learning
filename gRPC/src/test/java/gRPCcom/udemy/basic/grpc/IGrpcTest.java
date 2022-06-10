package gRPCcom.udemy.basic.grpc;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.udemy.basic.grpc.GrpcImpl;
import com.udemy.basic.grpc.IGrpc;

public class IGrpcTest {

	IGrpc grpc;

	@Before
	public void init() {
		grpc = new GrpcImpl();
	}

	/** building Grpc Server */
	@Test
	public void grpcServerBuildingTest() throws IOException, InterruptedException {
		grpc.createGrpcServer();
	}

	@Test
	public void balanceUnaryTest() {
		System.out.println("Received Balace :" + grpc.getBalanceUnary(5));
	}

	/** get balance streaming */
	@Test
	public void getBalanceStreamingTest() throws InterruptedException {
		grpc.getBalanceStreaming(10, 40);
	}

	/** Server Streaming Async Client */
	@Test
	public void getBalanceStreamingAsyncTest() throws InterruptedException {
		grpc.getBalanceStreamingAsync(10, 40);
	}

	/** Client streaming Request */
	@Test
	public void getBalanceClientStreamingTest() throws InterruptedException {
		grpc.getBalanceClientStreaming(10, 10);
	}

	/** Bi directional streaming transfer */
	@Test
	public void bidirectionalStreamingTransferTest() throws InterruptedException {
		grpc.bidirectionalStreamingTransfer();
	}

	/** Snack ladder game */
	@Test
	public void snacksLaderGameTest() throws InterruptedException {
		grpc.snacksLaderGame();
	}

	/** server load balancing test */
	@Test
	public void serverLoadbalancing() throws InterruptedException {
		grpc.serverLoadbalancing();
	}

	/** server load balancing streaing test */
	@Test
	public void serverLoadbalancingStreamingTest() throws InterruptedException {
		grpc.serverLoadbalancingStreaming();
	}
}
