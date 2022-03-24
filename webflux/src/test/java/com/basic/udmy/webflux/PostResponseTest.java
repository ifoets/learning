package com.basic.udmy.webflux;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class PostResponseTest extends BaseTest {

	@Autowired
	private WebClient webClient;

	String queryString = "http://localhost:8080/jobs/search?count={count}&page={page}";

	@Test
	public void queryParamsTest() {
		URI uri = UriComponentsBuilder.fromUriString(queryString)
		        .build(10, 20);

		Flux<Integer> monoResponse = this.webClient.get()
		        .uri(uri)
		        .retrieve()
		        .bodyToFlux(Integer.class)
		        .doOnNext(e -> System.out.println(e));

		StepVerifier.create(monoResponse)
		        .expectNextCount(2)
		        .verifyComplete();
	}

}
