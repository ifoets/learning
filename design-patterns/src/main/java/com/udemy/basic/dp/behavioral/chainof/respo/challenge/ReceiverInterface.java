package com.udemy.basic.dp.behavioral.chainof.respo.challenge;

public interface ReceiverInterface {
    boolean processMessage(Message message);
    void setNextChain(ReceiverInterface nextChain);
}
