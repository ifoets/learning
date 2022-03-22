package com.basic.udmy.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.udmy.webflux.dto.Response;
import com.basic.udmy.webflux.exception.InputValidationException;
import com.basic.udmy.webflux.service.IMathService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("vmath")
public class MathValidationController {

	@Autowired
	private IMathService mathService;

	@GetMapping("square/{input}")
	public Mono<Response> findSquare(@PathVariable int input) {
		if (input < 10 || input > 20)
			throw new InputValidationException(input);
		return this.mathService.findSquare(input);
	}

	@GetMapping("square/{input}/mono")
	public Mono<Response> findSquareMonoError(@PathVariable int input) {

		return Mono.just(input)
		        .handle((integer, sink) ->
			        {
				        if (integer >= 10 && integer <= 20)
					        sink.next(integer);
				        else
					        sink.error(new InputValidationException(integer));
			        })
		        .cast(Integer.class)
		        .flatMap(e -> mathService.findSquare(e));
	}

	@GetMapping("square/{input}/mono/empty")
	public Mono<ResponseEntity<Response>> findSquareMonoErrorEmpty(@PathVariable int input) {
		
		return Mono.just(input)
		        .filter(ei -> ei >= 10 && ei <= 20)
		        .flatMap(e -> mathService.findSquare(e))
		        .map(e -> ResponseEntity.ok()
		                .body(e))
		        .defaultIfEmpty(ResponseEntity.badRequest()
		                .build());
	}
}
