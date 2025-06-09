package org.example.controllers;

import org.example.classes.CalculationRequest;
import org.example.interfaces.IOperation;
import org.example.services.OperationService;
import org.example.services.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final OperationService operationService;
    private final HistoryService historyService;

    public CalculatorController(OperationService operationService,  HistoryService historyService) {
        this.operationService = operationService;
        this.historyService = historyService;
    }

    @PostMapping("/calculate")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> calculate(
            @RequestBody CalculationRequest request) {  // DTO класс
        try {
            IOperation operationObj = operationService.getOperation(request.getOperation());
            double result = operationObj.call(request.getArgs());

            String historyEntry = String.format("%s: %s = %.2f",
                    request.getOperation(),
                    Arrays.toString(request.getArgs()),
                    result);

            historyService.addHistory(historyEntry);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/operations")
    @CrossOrigin(origins = "*")
    public Set<String> getAvailableOperations() {
        return operationService.getAvailableOperations();
    }

    @GetMapping("/history")
    @CrossOrigin(origins = "*")
    public Set<String> getHistory() {
        System.out.println(historyService.getHistory());
        return historyService.getHistory();
    }
}
