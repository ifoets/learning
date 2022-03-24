package com.basic.udmy.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.basic.udmy.webflux.dto.MultiplyRequestDto;
import com.basic.udmy.webflux.dto.Response;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class HeaderTest extends BaseTest {

	@Autowired
	private WebClient webClient;

	@Test
	public void postTest() {
		Mono<Response> monoResponse = this.webClient.post()
		        .uri("math/multiply")
		        .bodyValue(buildRequestDto(10, 5))
		        .headers(e -> e.set("Some-Key", "Some-Value"))
		        // or set in webclient base url
		        // .headers(e->e.setBasicAuth("username", "password"))
		        .retrieve()
		        .bodyToMono(Response.class)
		        .doOnNext(e -> System.out.println(e.getOutput()));

		StepVerifier.create(monoResponse)
		        .expectNextCount(1)
		        .verifyComplete();
	}

	private MultiplyRequestDto buildRequestDto(int a, int b) {
		MultiplyRequestDto dto = new MultiplyRequestDto();
		dto.setFirst(a);
		dto.setSecond(b);
		return dto;
	}
}
