package com.udmy.orderservice.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udmy.orderservice.bus.RequestBusContext;
import com.udmy.orderservice.client.ProductClient;
import com.udmy.orderservice.client.UserClient;
import com.udmy.orderservice.dto.OrderRequestDto;
import com.udmy.orderservice.dto.ProductDto;
import com.udmy.orderservice.dto.PurchaseOrderDto;
import com.udmy.orderservice.dto.TransactionRequestDto;
import com.udmy.orderservice.dto.TransactionResponseDto;
import com.udmy.orderservice.repository.OrderRepository;
import com.udmy.orderservice.util.EntityDtoUtil;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.retry.Retry;

@Service
public class OrderFullfilmentService {

	@Autowired
	private ProductClient productClient;

	@Autowired
	private UserClient userClient;

	@Autowired
	private OrderRepository orderRepository;

	public Mono<PurchaseOrderDto> processOrder(Mono<OrderRequestDto> mono) {
		return mono.map(RequestBusContext::new)
		        .flatMap(this::productRequestResponse)
		        .doOnNext(EntityDtoUtil::setTransactionRequestDto)
		        .flatMap(this::userRequestRespnonse)
		        .map(EntityDtoUtil::getPurchaseOrder)
		        // .publishOn(Schedulers.boundedElastic()) or at last subscribe because blocking
		        // save here
		        .map(orderRepository::save) // blocking
		        .map(EntityDtoUtil::toDto)
		        .subscribeOn(Schedulers.boundedElastic()); // or before blocking publish on

	}

	private Mono<RequestBusContext> productRequestResponse(RequestBusContext bus) {
		return this.productClient.getProductById(bus.getOrderRequestDto()
		        .getProductId())
		        .doOnNext(bus::setProductDto)
		        // for intermitent issu
		        // .retry(5) quickly 5 times
		        .retryWhen(Retry.fixedDelay(5, Duration.ofSeconds(1)))
		        .thenReturn(bus);
	}

	private Mono<RequestBusContext> userRequestRespnonse(RequestBusContext bus) {
		return this.userClient.authorizedTransaction(bus.getTransactionRequestDto())
		        .doOnNext(bus::setTransactionResponseDto)
		        .thenReturn(bus);
	}

	public Mono<ProductDto> productproductById(String productId) {
		return this.productClient.getProductById(productId);

	}

	public Mono<TransactionResponseDto> getTransactionResponse(TransactionRequestDto dto) {
		return this.userClient.authorizedTransaction(dto);
	}

}
