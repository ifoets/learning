package com.udmy.orderservice.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class UserTransactionDto {

	private Integer id;
	private Integer userId;
	private Integer amount;
	private LocalDateTime transactionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "UserTransactionDto [id=" + id + ", userId=" + userId + ", amount=" + amount + ", transactionDate="
		        + transactionDate + "]";
	}

}
