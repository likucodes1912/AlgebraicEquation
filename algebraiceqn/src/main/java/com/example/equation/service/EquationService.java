package com.example.equation.service;

import com.example.equation.model.ExpressionNode;
import com.example.equation.util.Evaluator;
import com.example.equation.util.PostfixConverter;
import com.example.equation.util.TreeBuilder;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EquationService {

    private final Map<Integer, ExpressionNode> equationTreeMap = new HashMap<>();
    private final Map<Integer, String> equationInfixMap = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public Map<String, Object> storeEquation(String infix) {
        List<String> postfix = PostfixConverter.infixToPostfix(infix);
        ExpressionNode root = TreeBuilder.build(postfix);
        int id = idCounter.getAndIncrement();
        equationTreeMap.put(id, root);
        equationInfixMap.put(id, infix);

        return Map.of("message", "Equation stored successfully", "equationId", id);
    }

//    public Map<String, Object> getAllEquations() {
//        List<Map<String, Object>> list = equationInfixMap.entrySet().stream()
//            .map(e -> Map.of("equationId", e.getKey(), "equation", e.getValue()))
//            .collect(Collectors.toList());
//
//        return Map.of("equations", list);
//    }
    public Map<String, Object> getAllEquations() {
        List<Map<String, Object>> list = equationInfixMap.entrySet().stream()
            .map(e -> {
                Map<String, Object> map = new HashMap<>();
                map.put("equationId", e.getKey());
                map.put("equation", e.getValue());
                return map;
            })
            .collect(Collectors.toList());

        return Map.of("equations", list);
    }

    public Map<String, Object> evaluateEquation(int id, Map<String, Double> variables) {
        ExpressionNode root = equationTreeMap.get(id);
        String infix = equationInfixMap.get(id);
        double result = Evaluator.evaluate(root, variables);

        return Map.of("equationId", id, "equation", infix, "variables", variables, "result", result);
    }
}