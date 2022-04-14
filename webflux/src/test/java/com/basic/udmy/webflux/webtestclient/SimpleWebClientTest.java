package com.basic.udmy.webflux.webtestclient;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.basic.udmy.webflux.dto.Response;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@AutoConfigureWebTestClient
public class SimpleWebClientTest {

	// need to be fix client=null
	@Autowired
	private WebTestClient client;

	@Test
	public void stepVerifierTest() {

		Flux<Response> responseFlux = this.client.get()
		        .uri("math/square/{number}", 5)
		        .exchange()
		        .expectStatus()
		        .is2xxSuccessful()
		        .expectHeader()
		        .contentType(MediaType.APPLICATION_JSON)
		        .returnResult(Response.class)
		        .getResponseBody();
		System.out.println("Execute");

		StepVerifier.create(responseFlux)
		        .expectNextMatches(r -> r.getOutput() == 25)
		        .verifyComplete();

	}

	@Test
	public void fluentAssertionTest() {
		this.client.get()
		        .uri("math/square/{number}", 5)
		        .exchange()
		        .expectStatus()
		        .is2xxSuccessful()
		        .expectHeader()
		        .contentType(MediaType.APPLICATION_JSON)
		        .expectBody(Response.class)
		        .value(r -> Assertions.assertThat(r.getOutput())
		                .isEqualTo(25));

	}

}
