package com.basic.udmy.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.basic.udmy.webflux.dto.Response;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class GetMultiResponseTest extends BaseTest {

	@Autowired
	private WebClient webClient;

	@Test
	public void stepVerifierFluxTest() {
		Flux<Response> responseFlux = webClient.get()
		        .uri("math/table/{number}", 5)
		        .retrieve()
		        .bodyToFlux(Response.class)
		        .doOnNext(e -> System.out.println(e.getOutput()));// // Mono of response

		StepVerifier.create(responseFlux)
		        .expectNextCount(10)
		        .verifyComplete();
	}
	
	@Test
	public void stepVerifierFluxStreamTest() {
		Flux<Response> responseFlux = webClient.get()
		        .uri("math/table/{number}/stream", 5)
		        .retrieve()
		        .bodyToFlux(Response.class)
		        .doOnNext(e -> System.out.println(e.getOutput()));// // Mono of response

		StepVerifier.create(responseFlux)
		        .expectNextCount(10)
		        .verifyComplete();
	}
}
