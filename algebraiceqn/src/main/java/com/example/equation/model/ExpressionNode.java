package com.example.equation.model;

public class ExpressionNode {
    public String value;
    public ExpressionNode left, right;

    public ExpressionNode(String value) {
        this.value = value;
    }

    public boolean isOperator() {
        return "+-*/^".contains(value);
    }
}
