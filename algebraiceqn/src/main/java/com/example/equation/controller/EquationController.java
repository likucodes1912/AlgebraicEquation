package com.example.equation.controller;

import com.example.equation.dto.EquationRequest;
import com.example.equation.dto.EvaluationRequest;
import com.example.equation.service.EquationService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equations")
public class EquationController {

    @Autowired
    private EquationService equationService;

    @PostMapping("/store")
    public ResponseEntity<?> storeEquation(@RequestBody EquationRequest request) {
        return ResponseEntity.ok(equationService.storeEquation(request.getEquation()));
    }

    @GetMapping
    public ResponseEntity<?> getAllEquations() {
        return ResponseEntity.ok(equationService.getAllEquations());
    }

//    @PostMapping("/{id}/evaluate")
//    public ResponseEntity<?> evaluate(@PathVariable int id, @RequestBody EvaluationRequest request) {
//        return ResponseEntity.ok(equationService.evaluateEquation(id, request.getVariables()));
//    }
    @PostMapping("/{id}/evaluate")
    public ResponseEntity<?> evaluate(@PathVariable int id, @RequestBody EvaluationRequest request) {
        try {
            return ResponseEntity.ok(equationService.evaluateEquation(id, request.getVariables()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(404).body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(Map.of("error", "Evaluation failed: " + ex.getMessage()));
        }
    }    

}
