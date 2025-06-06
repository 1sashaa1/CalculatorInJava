package org.example;

import org.example.interfaces.IOperation;
import org.example.services.OperationService;

import java.util.Arrays;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        OperationService operations = new OperationService();

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("op: ");
                String op = scanner.nextLine().trim().toLowerCase();
                if (op.equals("exit")) {
                    break;
                }
                IOperation operation = operations.getOperation(op);
                if (operation == null) {
                    System.out.println("\u001B[31mОшибка: операция '" + op + "' не поддерживается\u001B[0m");
                    System.out.println("Доступные операции: " + operations.getAvailableOperations());
                    continue;
                }

                System.out.println("args: ");
                String[] argTokens = scanner.nextLine().trim().split("\\s+");
                double[] argsParsed = Arrays.stream(argTokens).mapToDouble(Double::parseDouble).toArray();

                double result = operation.call(argsParsed);
                System.out.println("Результат: " + result);

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}