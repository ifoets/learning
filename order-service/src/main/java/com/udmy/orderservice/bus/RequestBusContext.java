package com.udmy.orderservice.bus;

import com.udmy.orderservice.dto.OrderRequestDto;
import com.udmy.orderservice.dto.OrderResponseDto;
import com.udmy.orderservice.dto.ProductDto;
import com.udmy.orderservice.dto.TransactionRequestDto;
import com.udmy.orderservice.dto.TransactionResponseDto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Builder
public class RequestBusContext {

	private OrderRequestDto orderRequestDto;
	private OrderResponseDto orderResponseDto;
	private ProductDto productDto;
	private TransactionRequestDto transactionRequestDto;
	private TransactionResponseDto transactionResponseDto;

	public RequestBusContext(OrderRequestDto orderRequestDto) {
		this.orderRequestDto = orderRequestDto;
	}

	public OrderRequestDto getOrderRequestDto() {
		return orderRequestDto;
	}

	public void setOrderRequestDto(OrderRequestDto orderRequestDto) {
		this.orderRequestDto = orderRequestDto;
	}

	public OrderResponseDto getOrderResponseDto() {
		return orderResponseDto;
	}

	public void setOrderResponseDto(OrderResponseDto orderResponseDto) {
		this.orderResponseDto = orderResponseDto;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public TransactionRequestDto getTransactionRequestDto() {
		return transactionRequestDto;
	}

	public void setTransactionRequestDto(TransactionRequestDto transactionRequestDto) {
		this.transactionRequestDto = transactionRequestDto;
	}

	public TransactionResponseDto getTransactionResponseDto() {
		return transactionResponseDto;
	}

	public void setTransactionResponseDto(TransactionResponseDto transactionResponseDto) {
		this.transactionResponseDto = transactionResponseDto;
	}

}