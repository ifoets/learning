package com.udemy.basic.dp.behavioral.chainof.respo.challenge;
public class Message {
    private final MessagePriority priority;
    private final String text;

    public Message(MessagePriority priority, String text) {
        this.priority = priority;
        this.text = text;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public String getText() {
        return text;
    }
}
