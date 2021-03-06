package com.basic.udmy.webflux.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.udmy.webflux.dto.MultiplyRequestDto;
import com.basic.udmy.webflux.dto.Response;
import com.basic.udmy.webflux.service.IMathService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("math")
public class MathController {

	@Autowired
	private IMathService mathService;

	@GetMapping("square/{input}")
	public Mono<Response> findSquare(@PathVariable int input) {
		return this.mathService.findSquare(input);
	}

	@GetMapping("table/{input}")
	public Flux<Response> multiplicationTable(@PathVariable int input) {
		// AbstractJackson2Encoder
		// response internal work like Mono<List<Response>> ie it collect everything
		// before return
		return this.mathService.multiplicationTable(input);
	}

	@GetMapping(value = "table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Response> multiplicationTableStream(@PathVariable int input) {

		return this.mathService.multiplicationTable(input);
	}

	@PostMapping("multiply")
	public Mono<Response> multiply(@RequestBody Mono<MultiplyRequestDto> mono,
	        @RequestHeader Map<String, String> headers) {
		System.out.println(headers);
		return this.mathService.multiply(mono);
	}
}
