package com.udemy.basic.dp.behavioral.command.challenge;

import java.util.ArrayList;
import java.util.List;

import com.udemy.basic.dp.behavioral.command.challenge.command.Order;

public class Broker {
    private final List<Order> orders;

    public Broker() {
        this.orders = new ArrayList<>();
    }

    public void takeOrder(Order order) {
        orders.add(order);
    }

    public void placeOrders() {
        for (Order order : orders) {
            order.execute();
        }
        orders.clear();
    }
}
