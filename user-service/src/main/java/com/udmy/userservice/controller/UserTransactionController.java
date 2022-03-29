package com.udmy.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udmy.userservice.dto.TransactionRequestDto;
import com.udmy.userservice.dto.TransactionResponseDto;
import com.udmy.userservice.dto.UserTransactionDto;
import com.udmy.userservice.service.ITransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {

	@Autowired
	private ITransactionService transactionService;

	@PostMapping
	public Mono<TransactionResponseDto> createTransaction(@RequestBody Mono<TransactionRequestDto> requestDto) {
		return requestDto.flatMap(this.transactionService::createTransaction);
	}

	@GetMapping("{userId}")
	public Flux<UserTransactionDto> getTransactionByUserId(@PathVariable int userId) {
		return this.transactionService.getTransactionbyId(userId);
		      
	}

}
