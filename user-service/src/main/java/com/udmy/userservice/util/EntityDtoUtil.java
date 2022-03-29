package com.udmy.userservice.util;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.udmy.userservice.dto.TransactionRequestDto;
import com.udmy.userservice.dto.TransactionResponseDto;
import com.udmy.userservice.dto.TransactionStatus;
import com.udmy.userservice.dto.UserDto;
import com.udmy.userservice.dto.UserTransactionDto;
import com.udmy.userservice.entity.User;
import com.udmy.userservice.entity.UserTransaction;

public class EntityDtoUtil {

	public static UserDto toDto(User user) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}

	public static User toEntity(UserDto dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		return user;
	}

	public static UserTransaction toEntity(TransactionRequestDto dto) {
		UserTransaction userTransaction = new UserTransaction();
		userTransaction.setUserId(dto.getUserId());
		userTransaction.setAmount(dto.getBalance());
		userTransaction.setTransactionDate(LocalDateTime.now());
		return userTransaction;
	}

	public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status) {
		TransactionResponseDto responseDto = new TransactionResponseDto();
		responseDto.setUseId(requestDto.getUserId());
		responseDto.setBalance(requestDto.getBalance());
		responseDto.setStatus(status);
		return responseDto;
	}

	public static UserTransactionDto toDto(UserTransaction userTransaction) {
		UserTransactionDto dto = new UserTransactionDto();
		BeanUtils.copyProperties(userTransaction, dto);
		return dto;
	}
}
