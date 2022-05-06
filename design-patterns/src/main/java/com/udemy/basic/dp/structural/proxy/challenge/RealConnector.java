package com.udemy.basic.dp.structural.proxy.challenge;

public class RealConnector implements Connector {
    public RealConnector() {
    }

    @Override
    public void connect(String address) {
        System.out.println("Connects with: " + address);
    }
}
