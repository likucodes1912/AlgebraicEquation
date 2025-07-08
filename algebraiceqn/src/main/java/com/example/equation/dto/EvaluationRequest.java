package com.example.equation.dto;

import java.util.HashMap;
import java.util.Map;

public class EvaluationRequest {
    private Map<String, Double> variables;

    public Map<String, Double> getVariables() {
        return variables != null ? variables : new HashMap<>();
    }

    public void setVariables(Map<String, Double> variables) {
        this.variables = variables;
    }
}
