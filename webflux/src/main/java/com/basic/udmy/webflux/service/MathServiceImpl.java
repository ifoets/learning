package com.basic.udmy.webflux.service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.basic.udmy.webflux.dto.CalculatorDto;
import com.basic.udmy.webflux.dto.MultiplyRequestDto;
import com.basic.udmy.webflux.dto.Response;
import com.basic.udmy.webflux.utils.SleepUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("mathService")
public class MathServiceImpl implements IMathService {

	@Override
	public Mono<Response> findSquare(int input) {
		return Mono.fromSupplier(() -> input * input)
		        .map(Response::new);
	}

	// this is not reactive since not in pipe line
	@Override
	public Flux<Response> multiplicationTableNonReactive(int input) {
		List<Response> list = IntStream.rangeClosed(1, 10)
		        .peek(e -> SleepUtil.sleepSecond(1))
		        .peek(i -> System.out.println("Processing element : " + i))
		        .mapToObj(ei -> new Response(ei * input))
		        .collect(Collectors.toList());
		return Flux.fromIterable(list);

	}

	@Override
	public Flux<Response> multiplicationTable(int input) {

		return Flux.range(1, 10)
		        .delayElements(Duration.ofSeconds(1))// non blocking sleep quick effect
		        // .doOnNext(i -> SleepUtil.sleepSecond(1))// blocking sleep take bit time
		        .doOnNext(i -> System.out.println("Processing element : " + i))
		        .map(ei -> new Response(ei * input));
	}

	@Override
	public Mono<Response> multiply(Mono<MultiplyRequestDto> mono) {
		return mono.map(e -> e.getFirst() * e.getSecond())
		        .map(Response::new);
	}

	@Override
	public Mono<Response> calculator(Mono<CalculatorDto> mono, String op) {

		switch (op) {
		case "+":
			return mono.map(e -> e.getNum1() + e.getNum2())
			        .map(Response::new);
		case "-":
			return mono.map(e -> e.getNum1() - e.getNum2())
			        .map(Response::new);
		case "*":
			return mono.map(e -> e.getNum1() * e.getNum2())
			        .map(Response::new);
		case "/":
			return mono.map(e -> e.getNum1() / e.getNum2())
			        .map(Response::new);
		case "%":
			return mono.map(e -> e.getNum1() % e.getNum2())
			        .map(Response::new);
		}

		return Mono.empty();

	}
}
