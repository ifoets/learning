package com.udemy.basic.dp.behavioral.chainof.responsibility;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency currency);
}
