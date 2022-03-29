package com.udmy.userservice.service;

import org.springframework.stereotype.Service;

import com.udmy.userservice.dto.TransactionRequestDto;
import com.udmy.userservice.dto.TransactionResponseDto;
import com.udmy.userservice.dto.UserTransactionDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ITransactionService {

	public Mono<TransactionResponseDto> createTransaction(TransactionRequestDto requestDto);

	public Flux<UserTransactionDto> getTransactionbyId(Integer userId);
}
