package com.udmy.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.udmy.orderservice.dto.OrderRequestDto;
import com.udmy.orderservice.dto.ProductDto;
import com.udmy.orderservice.dto.PurchaseOrderDto;
import com.udmy.orderservice.dto.TransactionRequestDto;
import com.udmy.orderservice.dto.TransactionResponseDto;
import com.udmy.orderservice.service.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("create")
	public Mono<PurchaseOrderDto> createOrder(@RequestBody PurchaseOrderDto dto) {
		return orderService.save(dto);
	}

	@GetMapping("{orderId}")
	public Mono<PurchaseOrderDto> getByOrderId(@PathVariable int orderId) {
		return orderService.getByOrderId(orderId);
	}
 
	@GetMapping("user/{userId}")
	public Flux<PurchaseOrderDto> getByUserId(@PathVariable int userId) {
		return orderService.getByUserId(userId);
	}

	@PostMapping("place")
	public Mono<ResponseEntity<PurchaseOrderDto>> processOrder(@RequestBody Mono<OrderRequestDto> requestDto) {
		return orderService.placeOrder(requestDto)
		        .map(ResponseEntity::ok)
		        .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest()
		                .build())
		        .onErrorReturn(WebClientRequestException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
		                .build());
	}

	@GetMapping("product/{productId}")
	public Mono<ProductDto> productproductById(@PathVariable String productId) {
		return this.orderService.productproductById(productId);

	}

	@PostMapping("{transaction}")
	public Mono<TransactionResponseDto> getTransactionResponse(@RequestBody TransactionRequestDto dto) {
		return this.orderService.getTransactionResponse(dto);
	}
}
