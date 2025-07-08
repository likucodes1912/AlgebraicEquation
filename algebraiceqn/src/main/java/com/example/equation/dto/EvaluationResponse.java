package com.example.equation.dto;

import java.util.Map;

public class EvaluationResponse {

	private int equationId;
    private String equation;
    private Map<String, Double> variables;
    private double result;
    
    
    
	public int getEquationId() {
		return equationId;
	}
	public void setEquationId(int equationId) {
		this.equationId = equationId;
	}
	public String getEquation() {
		return equation;
	}
	public void setEquation(String equation) {
		this.equation = equation;
	}
	public Map<String, Double> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, Double> variables) {
		this.variables = variables;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	
	@Override
	public String toString() {
		return "EvaluationResponse [equationId=" + equationId + ", equation=" + equation + ", variables=" + variables
				+ ", result=" + result + "]";
	}
    
    
}
