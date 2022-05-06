package com.udemy.basic.dp.behavioral.command.challenge.command;

import com.udemy.basic.dp.behavioral.command.challenge.receiver.Stock;

public class BuyStock implements Order {
    private final Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
