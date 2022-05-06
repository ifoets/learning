package com.udemy.basic.dp.behavioral.chainof.respo.challenge;

public class IssueRaiser {
    private final ReceiverInterface firstReceiver;

    public IssueRaiser() {
        this.firstReceiver = new FaxErrorHandler();
        ReceiverInterface e2 = new EmailErrorHandler();

        firstReceiver.setNextChain(e2);
    }

    public void raiseMessage(Message msg) {
        if (firstReceiver != null) {
            firstReceiver.processMessage(msg);
        }
    }
}
