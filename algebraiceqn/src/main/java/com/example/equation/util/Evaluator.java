package com.example.equation.util;

import java.util.Map;

import com.example.equation.model.ExpressionNode;

public class Evaluator {
    public static double evaluate(ExpressionNode node, Map<String, Double> vars) {
        if (!node.isOperator()) {
            if (node.value.matches("[a-zA-Z]+")) return vars.getOrDefault(node.value, 0.0);
            return Double.parseDouble(node.value);
        }
        double left = evaluate(node.left, vars);
        double right = evaluate(node.right, vars);
        return switch (node.value) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            case "^" -> Math.pow(left, right);
            default -> throw new RuntimeException("Unknown operator");
        };
    }
}