package com.udmy.orderservice.util;

import org.springframework.beans.BeanUtils;

import com.udmy.orderservice.bus.RequestBusContext;
import com.udmy.orderservice.dto.OrderStatus;
import com.udmy.orderservice.dto.PurchaseOrderDto;
import com.udmy.orderservice.dto.TransactionRequestDto;
import com.udmy.orderservice.dto.TransactionStatus;
import com.udmy.orderservice.entity.PurchaseOrder;

public class EntityDtoUtil {
	

	public static PurchaseOrderDto toDto(PurchaseOrder purchaseOrder) {
		PurchaseOrderDto dto = new PurchaseOrderDto();
		BeanUtils.copyProperties(purchaseOrder, dto);
		return dto;
	}

	public static PurchaseOrder toEntity(PurchaseOrderDto dto) {
		PurchaseOrder order = new PurchaseOrder();
		BeanUtils.copyProperties(dto, order);
		return order;
	}

	public static void setTransactionRequestDto(RequestBusContext bus) {
		TransactionRequestDto dto = new TransactionRequestDto();
		dto.setUserId(bus.getOrderRequestDto()
		        .getUserId());
		dto.setBalance(bus.getProductDto()
		        .getPrice());
		bus.setTransactionRequestDto(dto);
	}

	public static PurchaseOrder getPurchaseOrder(RequestBusContext bus) {
		PurchaseOrder purchaseOrder = new PurchaseOrder();

		purchaseOrder.setUserId(bus.getOrderRequestDto()
		        .getUserId());
		purchaseOrder.setProductId(bus.getOrderRequestDto()
		        .getProductId());
		purchaseOrder.setAmount(bus.getProductDto()
		        .getPrice());
		TransactionStatus status = bus.getTransactionResponseDto()
		        .getStatus();
		purchaseOrder.setStatus(TransactionStatus.APPROVED.equals(status) ? OrderStatus.CMPLETED : OrderStatus.FAILED);
		return purchaseOrder;
	}
}
