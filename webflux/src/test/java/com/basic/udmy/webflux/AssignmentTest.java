package com.basic.udmy.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.basic.udmy.webflux.utils.SleepUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class AssignmentTest extends BaseTest {

	@Autowired
	private WebClient webClient;
	private final String FORMAT = "%d %s %d = %s";
	private final int A = 10;

	@Test
	public void assignmentTest() {

		Flux<String> flux = Flux.range(1, 5)
		        .flatMap(b -> Flux.just("+", "-", "*", "/")
		                .flatMap(op -> send(b, op)))
		        .doOnNext(System.out::println);

		StepVerifier.create(flux)
		        .expectNextCount(20)
		        .verifyComplete();
	}

	public Mono<String> send(int b, String op) {
		SleepUtil.sleepSecond(1);
		return this.webClient.get()
		        .uri("calculate/{a}/{b}", A, b)
		        .headers(h -> h.set("OP", op))
		        .retrieve()
		        .bodyToMono(String.class)
		        .map(v -> String.format(FORMAT, A, op, b, v));
	}

}
