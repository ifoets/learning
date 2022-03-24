package com.basic.udmy.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.basic.udmy.webflux.dto.Response;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class GetSingleResponseTest extends BaseTest {

	@Autowired
	private WebClient webClient;

	@Test
	public void blockTest() {
		Response response = webClient.get()
		        .uri("math/square/{number}", 5)
		        .retrieve()
		        .bodyToMono(Response.class) // Mono of response
		        .block();
		System.out.println(response.toString());
	}

	@Test
	public void stepVerifierTest() {
		Mono<Response> responseMono = webClient.get()
		        .uri("math/square/{number}", 5)
		        .retrieve()
		        .bodyToMono(Response.class);// // Mono of response

		StepVerifier.create(responseMono)
		        .expectNextMatches(r -> r.getOutput() == 25)
		        .verifyComplete();
	}
}
