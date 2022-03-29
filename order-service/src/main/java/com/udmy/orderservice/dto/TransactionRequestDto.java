package com.udmy.orderservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class TransactionRequestDto {

	private Integer userId;
	private Integer balance;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer useId) {
		this.userId = useId;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "TransactionRequestDto [useId=" + userId + ", balance=" + balance + "]";
	}

}
