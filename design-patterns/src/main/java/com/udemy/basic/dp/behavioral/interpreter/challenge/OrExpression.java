package com.udemy.basic.dp.behavioral.interpreter.challenge;


public class OrExpression implements Expression {
    private final Expression expr1;
    private final Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(Context c) {
        return expr1.interpret(c) || expr2.interpret(c);
    }
}
