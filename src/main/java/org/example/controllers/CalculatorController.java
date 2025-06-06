package org.example.controllers;

import org.example.interfaces.IOperation;
import org.example.services.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final OperationService operationService;

    public CalculatorController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(
            @RequestParam String operation,
            @RequestParam double[] args) {
        try {
            IOperation operation1 = operationService.getOperation(operation);
            double result = operation1.call(args);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/operations")
    public Set<String> getAvailableOperations() {
        return operationService.getAvailableOperations();
    }
}
