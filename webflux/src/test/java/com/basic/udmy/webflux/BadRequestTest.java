package com.basic.udmy.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.basic.udmy.webflux.dto.Response;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class BadRequestTest extends BaseTest {

	@Autowired
	private WebClient webClient;

	@Test
	public void stepVerifierExceptionTest() {
		Mono<Response> responseMono = this.webClient.get()
		        .uri("vmath/square/{number}", 5)
		        .retrieve()
		        .bodyToMono(Response.class)
		        .doOnNext(e -> System.out.println(e.getOutput()))// // Mono of response
		        .doOnError(err -> System.out.println(err));

		StepVerifier.create(responseMono)
		        .verifyError(WebClientResponseException.BadRequest.class);
	}

}
