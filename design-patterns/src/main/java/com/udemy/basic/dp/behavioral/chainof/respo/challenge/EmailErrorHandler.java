package com.udemy.basic.dp.behavioral.chainof.respo.challenge;

public class EmailErrorHandler implements ReceiverInterface {
    private ReceiverInterface nextReceiver;

    @Override
    public void setNextChain(ReceiverInterface nextReceiver) {
        this.nextReceiver = nextReceiver;
    }

    @Override
    public boolean processMessage(Message message) {
        if (message.getText().contains("Email")) {
            System.out.println("Email Error Handler: " + message.getPriority().name() + " " + message.getText());
            return true;
        } else {
            if (nextReceiver != null) {
                nextReceiver.processMessage(message);
            }
        }
        return false;
    }
}
