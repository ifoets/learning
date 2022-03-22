package com.basic.udmy.webflux.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CalculatorConfig {

	@Autowired
	private CalculatorHandler calculatorHandler;

	@Bean
	public RouterFunction<ServerResponse> higherCalclatorRouter() {

		return RouterFunctions.route()
		        .path("calculate", this::serverResponseRouterCalculator)
		        .build();
	}

	public RouterFunction<ServerResponse> serverResponseRouterCalculator() {

		return RouterFunctions.route()
		        .GET("{a}/{b}", isOpertion("+"), calculatorHandler::addititionHandler)
		        .GET("{a}/{b}", isOpertion("-"), calculatorHandler::subtractionHandler)
		        .GET("{a}/{b}", isOpertion("*"), calculatorHandler::multiplicationHandler)
		        .GET("{a}/{b}", isOpertion("/"), calculatorHandler::divisionHandler)
		        .GET("{a}/{b}", isOpertion("%"), calculatorHandler::modularHandler)
		        .GET("{a}/{b}", req -> ServerResponse.badRequest()
		                .bodyValue("Key must be OP and OP +-*/% allowed only !!"))

		        .build();
	}

	private RequestPredicate isOpertion(String op) {
		return RequestPredicates.headers(headers -> op.equals(headers.asHttpHeaders()
		        .toSingleValueMap()
		        .get("OP")));
	}

}
