package com.udmy.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udmy.orderservice.client.ProductClient;
import com.udmy.orderservice.client.UserClient;
import com.udmy.orderservice.dto.OrderRequestDto;
import com.udmy.orderservice.dto.ProductDto;
import com.udmy.orderservice.dto.PurchaseOrderDto;
import com.udmy.orderservice.dto.UserDto;
import com.udmy.orderservice.service.OrderFullfilmentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private UserClient userClient;

	@Autowired
	private ProductClient productClient;

	@Autowired
	private OrderFullfilmentService fullfilmentService;

	@Test
	void contextLoads() {

		Flux<PurchaseOrderDto> ordeDto = Flux.zip(userClient.getAllUser(), productClient.getAllProducts())
		        .map(t -> buildDto(t.getT1(), t.getT2()))
		        .flatMap(dto -> this.fullfilmentService.processOrder(Mono.just(dto)))
		        .doOnNext(System.out::println);

		StepVerifier.create(ordeDto)
		        .expectNextCount(4)
		        .verifyComplete();
	}

	private OrderRequestDto buildDto(UserDto userDto, ProductDto productDto) {
		OrderRequestDto dto = new OrderRequestDto();
		dto.setUserId(userDto.getId());
		dto.setProductId(productDto.getId());
		return dto;
	}

}
