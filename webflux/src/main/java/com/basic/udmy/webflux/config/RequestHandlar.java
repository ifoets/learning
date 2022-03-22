package com.basic.udmy.webflux.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.basic.udmy.webflux.dto.MultiplyRequestDto;
import com.basic.udmy.webflux.dto.Response;
import com.basic.udmy.webflux.exception.InputValidationException;
import com.basic.udmy.webflux.service.IMathService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestHandlar {

	@Autowired
	private IMathService mathService;

	public Mono<ServerResponse> sqaureHandler(ServerRequest serverRequest) {

		int input = Integer.parseInt(serverRequest.pathVariable("input"));
		Mono<Response> responseMono = mathService.findSquare(input);
		return ServerResponse.ok()
		        .body(responseMono, Response.class);
	}

	public Mono<ServerResponse> tableHandler(ServerRequest serverRequest) {

		int input = Integer.parseInt(serverRequest.pathVariable("input"));
		Flux<Response> responseFlux = mathService.multiplicationTable(input);
		return ServerResponse.ok()
		        .body(responseFlux, Response.class);
	}

	public Mono<ServerResponse> tableStreamHandler(ServerRequest serverRequest) {

		int input = Integer.parseInt(serverRequest.pathVariable("input"));
		Flux<Response> responseFlux = mathService.multiplicationTable(input);
		return ServerResponse.ok()
		        .contentType(MediaType.TEXT_EVENT_STREAM)
		        .body(responseFlux, Response.class);
	}

	public Mono<ServerResponse> multiplyHandler(ServerRequest serverRequest) {

		Mono<MultiplyRequestDto> monoRequest = serverRequest.bodyToMono(MultiplyRequestDto.class);
		Mono<Response> responseMono = mathService.multiply(monoRequest);
		return ServerResponse.ok()
		        .body(responseMono, Response.class);
	}

	public Mono<ServerResponse> sqaureHandlerValidation(ServerRequest serverRequest) {

		int input = Integer.parseInt(serverRequest.pathVariable("input"));
		if (input < 10 || input > 20)
			return Mono.error(new InputValidationException(input));

		Mono<Response> responseMono = mathService.findSquare(input);
		return ServerResponse.ok()
		        .body(responseMono, Response.class);
	}

}