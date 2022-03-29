package com.udmy.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udmy.orderservice.entity.PurchaseOrder;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<PurchaseOrder, Integer> {

	public List<PurchaseOrder> findByUserId(int userId);
	
	public PurchaseOrder findByOrderId(int orderId);

}
