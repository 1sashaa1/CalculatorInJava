package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Map<String, IOperation> operations = new HashMap<>();

        operations.put("+", (double... a) -> {
            if (a.length < 2) throw new IllegalArgumentException("Нужно минимум 2 аргумента");
            return a[0] + a[1];
        });

        operations.put("sin", (double... a) -> {
            if (a.length < 1) throw new IllegalArgumentException("Нужен 1 аргумент");
            return Math.sin(a[0]);
        });

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("op: ");
                String op = scanner.nextLine().trim().toLowerCase();
                if (op.equals("exit")) {
                    break;
                }

                System.out.println("args: ");
                String[] argTokens = scanner.nextLine().trim().split("//s+");
                double[] argsParsed = Arrays.stream(argTokens).mapToDouble(Double::parseDouble).toArray();

                IOperation operation = operations.get(op);

                if (operation == null) {
                    System.out.println("Ошибка: операция не найдена");
                    continue;
                }

                double result = operation.call(argsParsed);
                System.out.println("Результат: " + result);

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}