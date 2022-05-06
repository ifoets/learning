package com.udemy.basic.dp.behavioral.interpreter.challenge;


public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(Context c) {
        return c.getResult(data);
    }
}
