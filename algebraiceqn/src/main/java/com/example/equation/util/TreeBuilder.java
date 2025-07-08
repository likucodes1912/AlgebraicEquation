package com.example.equation.util;

import java.util.List;
import java.util.Stack;

import com.example.equation.model.ExpressionNode;

public class TreeBuilder {
    public static ExpressionNode build(List<String> postfix) {
        Stack<ExpressionNode> stack = new Stack<>();
        for (String token : postfix) {
            ExpressionNode node = new ExpressionNode(token);
            if (node.isOperator()) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.push(node);
        }
        return stack.pop();
    }
}
