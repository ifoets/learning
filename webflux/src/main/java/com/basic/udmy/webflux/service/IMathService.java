package com.basic.udmy.webflux.service;

import com.basic.udmy.webflux.dto.CalculatorDto;
import com.basic.udmy.webflux.dto.MultiplyRequestDto;
import com.basic.udmy.webflux.dto.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMathService {

	public Mono<Response> findSquare(int input);

	// this is not reactive since not in pipe line
	public Flux<Response> multiplicationTableNonReactive(int input);

	public Flux<Response> multiplicationTable(int input);

	public Mono<Response> multiply(Mono<MultiplyRequestDto> mono);

	public Mono<Response> calculator(Mono<CalculatorDto> mono, String op);

}
