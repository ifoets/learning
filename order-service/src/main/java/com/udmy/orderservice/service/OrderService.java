package com.udmy.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udmy.orderservice.dto.OrderRequestDto;
import com.udmy.orderservice.dto.ProductDto;
import com.udmy.orderservice.dto.PurchaseOrderDto;
import com.udmy.orderservice.dto.TransactionRequestDto;
import com.udmy.orderservice.dto.TransactionResponseDto;
import com.udmy.orderservice.repository.OrderRepository;
import com.udmy.orderservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderFullfilmentService orderFullfilmentService;

	public Flux<PurchaseOrderDto> getAll() {
		return Flux.fromStream(() -> this.orderRepository.findAll()
		        .stream()) // blocking
		        .map(EntityDtoUtil::toDto)
		        .subscribeOn(Schedulers.boundedElastic());
	}

	public Mono<PurchaseOrderDto> getByOrderId(int orderId) {
		return Mono.fromSupplier(() -> EntityDtoUtil.toDto(orderRepository.findByOrderId(orderId)))
		        .subscribeOn(Schedulers.boundedElastic());
	}

	public Flux<PurchaseOrderDto> getByUserId(int userId) {
		return Flux.fromStream(() -> this.orderRepository.findByUserId(userId)
		        .stream()) // blocking
		        .map(EntityDtoUtil::toDto)
		        .subscribeOn(Schedulers.boundedElastic());
	}

	public Mono<PurchaseOrderDto> save(PurchaseOrderDto dto) {

		return Mono.fromSupplier(() -> EntityDtoUtil.toDto(orderRepository.saveAndFlush(EntityDtoUtil.toEntity(dto))))
		        .subscribeOn(Schedulers.boundedElastic());

	}

	public Mono<PurchaseOrderDto> placeOrder(Mono<OrderRequestDto> requestMono) {
		return orderFullfilmentService.processOrder(requestMono);
	}

	public Mono<ProductDto> productproductById(String productId) {
		return this.orderFullfilmentService.productproductById(productId);

	}

	public Mono<TransactionResponseDto> getTransactionResponse(TransactionRequestDto dto) {
		return this.orderFullfilmentService.getTransactionResponse(dto);
	}
}
