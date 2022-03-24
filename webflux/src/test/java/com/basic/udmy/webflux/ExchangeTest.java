package com.basic.udmy.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.basic.udmy.webflux.dto.Response;
import com.basic.udmy.webflux.dto.ValidationResponse;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ExchangeTest extends BaseTest {

	@Autowired
	private WebClient webClient;

	// exchange =retrieve +additional info http status code

	@Test
	public void stepVerifierExceptionTest() {
		Mono<Object> responseMono = this.webClient.get()
		        .uri("vmath/square/{number}", 5)
		        .exchangeToMono(this::dynamicExchage)
		        .doOnNext(e -> System.out.println(e))
		        .doOnError(err -> System.out.println(err.toString()));

		StepVerifier.create(responseMono)
		        .expectNextCount(1)
		        .verifyComplete();
	}

	@Test
	public void stepVerifierResponseTest() {
		Mono<Object> responseMono = this.webClient.get()
		        .uri("vmath/square/{number}", 15)
		        .exchangeToMono(this::dynamicExchage)
		        .doOnNext(e -> System.out.println(e))
		        .doOnError(err -> System.out.println(err.toString()));

		StepVerifier.create(responseMono)
		        .expectNextCount(1)
		        .verifyComplete();
	}

	private Mono<Object> dynamicExchage(ClientResponse cr) {
		if (cr.rawStatusCode() == 400)
			return cr.bodyToMono(ValidationResponse.class);
		else
			return cr.bodyToMono(Response.class);
	}

}
