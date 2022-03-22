package com.basic.udmy.webflux.config;

import java.util.function.BiFunction;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class CalculatorHandler {

	public Mono<ServerResponse> addititionHandler(ServerRequest serverRequest) {
		return process(serverRequest, (a, b) -> ServerResponse.ok()
		        .bodyValue(a + b));
	}

	public Mono<ServerResponse> subtractionHandler(ServerRequest serverRequest) {
		return process(serverRequest, (a, b) -> ServerResponse.ok()
		        .bodyValue(a - b));
	}

	public Mono<ServerResponse> multiplicationHandler(ServerRequest serverRequest) {

		return process(serverRequest, (a, b) -> ServerResponse.ok()
		        .bodyValue(a * b));
	}

	public Mono<ServerResponse> divisionHandler(ServerRequest serverRequest) {
		return process(serverRequest, (a, b) -> b != 0 ? ServerResponse.ok()
		        .bodyValue(a / b)
		        : ServerResponse.badRequest()
		                .bodyValue("b can't be 0"));
	}

	public Mono<ServerResponse> modularHandler(ServerRequest serverRequest) {
		return process(serverRequest, (a, b) -> b != 0 ? ServerResponse.ok()
		        .bodyValue(a % b)
		        : ServerResponse.badRequest()
		                .bodyValue("b can't be 0"));
	}

	private Mono<ServerResponse> process(ServerRequest reqest,
	        BiFunction<Integer, Integer, Mono<ServerResponse>> opLogic) {
		int a = getValue(reqest, "a");
		int b = getValue(reqest, "b");
		return opLogic.apply(a, b);
	}

	private int getValue(ServerRequest request, String key) {
		return Integer.parseInt(request.pathVariable(key));
	}
}
