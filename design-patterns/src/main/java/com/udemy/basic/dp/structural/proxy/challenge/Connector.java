package com.udemy.basic.dp.structural.proxy.challenge;

import java.net.ConnectException;

public interface Connector {
    void connect(String address) throws ConnectException;
}
