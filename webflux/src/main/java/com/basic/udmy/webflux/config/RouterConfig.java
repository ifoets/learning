package com.basic.udmy.webflux.config;

import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.basic.udmy.webflux.dto.ValidationResponse;
import com.basic.udmy.webflux.exception.InputValidationException;

import reactor.core.publisher.Mono;

@Configuration
public class RouterConfig {

	@Autowired
	private RequestHandlar requestHandlar;

	@Bean
	public RouterFunction<ServerResponse> higherRouter() {

		return RouterFunctions.route()
		        .path("router", this::serverResponseRouterFunctions)
		        .path("routerx", this::serverResponseRouterFunctionsx)
		        .build();
	}

	// @Bean
	public RouterFunction<ServerResponse> serverResponseRouterFunctions() {

		return RouterFunctions.route()
		        .GET("square/{input}", requestHandlar::sqaureHandler)
		        .GET("table/{input}", requestHandlar::tableHandler)
		        .GET("stream/table/{input}", requestHandlar::tableStreamHandler)
		        .POST("multiply", requestHandlar::multiplyHandler)
		        .GET("square/{input}/validation", requestHandlar::sqaureHandlerValidation)
		        .onError(InputValidationException.class, exceptionHandlar())
		        .build();
	}

	// @Bean
	public RouterFunction<ServerResponse> serverResponseRouterFunctionsx() {

		return RouterFunctions.route()
		        .GET("square/{input}", RequestPredicates.path("*/1?")
		                .or(RequestPredicates.path("*/20")), requestHandlar::sqaureHandler)
		        .GET("square/{input}", req -> ServerResponse.badRequest()
		                .bodyValue("1-20 allowed only !!"))
		        .GET("table/{input}", requestHandlar::tableHandler)
		        .GET("stream/table/{input}", requestHandlar::tableStreamHandler)
		        .POST("multiply", requestHandlar::multiplyHandler)
		        .GET("square/{input}/validation", requestHandlar::sqaureHandlerValidation)
		        .build();
	}

	private BiFunction<Throwable, ServerRequest, Mono<ServerResponse>> exceptionHandlar() {
		return (err, req) ->
			{
				InputValidationException ex = (InputValidationException) err;
				ValidationResponse validationResponse = new ValidationResponse(ex.getErrorcode(), ex.getInput(),
				        ex.getMessage());
				return ServerResponse.ok()
				        .bodyValue(validationResponse);
			};
	}

}
