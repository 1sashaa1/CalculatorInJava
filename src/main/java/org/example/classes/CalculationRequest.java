package org.example.classes;

public class CalculationRequest {
    private String operation;
    private double[] args;

    public double[] getArgs() {
        return args;
    }

    public void setArgs(double[] args) {
        this.args = args;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}