package com.udmy.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udmy.userservice.dto.TransactionRequestDto;
import com.udmy.userservice.dto.TransactionResponseDto;
import com.udmy.userservice.dto.TransactionStatus;
import com.udmy.userservice.dto.UserTransactionDto;
import com.udmy.userservice.repository.UserRepository;
import com.udmy.userservice.repository.UserTransactionRepository;
import com.udmy.userservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserTransactionRepository transactionRepository;

	public Mono<TransactionResponseDto> createTransaction(TransactionRequestDto requestDto) {
		return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getBalance())
		        .filter(Boolean::booleanValue)
		        .map(b -> EntityDtoUtil.toEntity(requestDto))
		        .flatMap(this.transactionRepository::save)
		        .map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
		        .defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));
	}

	@Override
	public Flux<UserTransactionDto> getTransactionbyId(Integer userId) {
		return this.transactionRepository.findByUserId(userId)
		        .map(EntityDtoUtil::toDto);
	}
}
