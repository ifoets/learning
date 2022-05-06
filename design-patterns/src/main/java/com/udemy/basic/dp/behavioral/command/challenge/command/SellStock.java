package com.udemy.basic.dp.behavioral.command.challenge.command;

import com.udemy.basic.dp.behavioral.command.challenge.receiver.Stock;

public class SellStock implements Order {
    private final Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
