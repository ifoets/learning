package com.udmy.orderservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class TransactionResponseDto {

	private Integer userId;
	private Integer balance;

	private TransactionStatus status;

	public Integer getUserId() {
		return userId;
	}

	public void setUseId(Integer useId) {
		this.userId = useId;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TransactionRequestDto [userId=" + userId + ", balance=" + balance + "]";
	}

}
