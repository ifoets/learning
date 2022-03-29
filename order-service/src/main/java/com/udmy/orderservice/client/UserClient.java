package com.udmy.orderservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.udmy.orderservice.dto.TransactionRequestDto;
import com.udmy.orderservice.dto.TransactionResponseDto;
import com.udmy.orderservice.dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserClient {

	private WebClient webClient;

	public UserClient(@Value("${user.service.url}") String url) {
		this.webClient = WebClient.builder()
		        .baseUrl(url)
		        .build();
	}

	public Mono<UserDto> getUserById(int userId) {

		return this.webClient.get()
		        .uri("{id}", userId)
		        .retrieve()
		        .bodyToMono(UserDto.class);
	}

	public Flux<UserDto> getAllUser() {
		return this.webClient.get()
		        .uri("all")
		        .retrieve()
		        .bodyToFlux(UserDto.class);
	}

	public Mono<TransactionResponseDto> authorizedTransaction(TransactionRequestDto transactionRequestDto) {
		return this.webClient.post()
		        .uri("transaction")
		        .bodyValue(transactionRequestDto)
		        .retrieve()
		        .bodyToMono(TransactionResponseDto.class);
	}
}
