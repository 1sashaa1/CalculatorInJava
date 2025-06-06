package org.example.services;

import org.example.interfaces.IOperation;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OperationService {

    Map<String, IOperation> operations = new HashMap<>();

    public OperationService(){
        operations.put("+", (double... a) -> {
        if (a.length < 2) throw new IllegalArgumentException("Нужно минимум 2 аргумента");
        return Arrays.stream(a).sum();
    });

        operations.put("-", (double... a) -> {
        if (a.length < 2) throw new IllegalArgumentException("Нужно минимум 2 аргумента");
        return a[0] - Arrays.stream(a).skip(1).sum();
    });

        operations.put("*", (double... a) -> {
        if (a.length < 2) throw new IllegalArgumentException("Нужно минимум 2 аргумента");
        return  Arrays.stream(a)
                .reduce(1.0, (acc, num) -> acc * num);
    });

        operations.put("/", (double... a) -> {
        if (a.length < 2) throw new IllegalArgumentException("Нужно ровно 2 аргумента");
        if (a[1] == 0) throw new ArithmeticException("Второй аргумент не должен быть равен 0");
        return a[0] / a[1];
    });

        operations.put("sin", (double... a) -> {
        if (a.length < 1) throw new IllegalArgumentException("Нужен 1 аргумент");
        return Math.sin(a[0]);
    });

        operations.put("cos", (double... a) -> {
        if (a.length < 1) throw new IllegalArgumentException("Нужен 1 аргумент");
        return Math.cos(a[0]);
    });

        operations.put("tan", (double... a) -> {
        if (a.length < 1) throw new IllegalArgumentException("Нужен 1 аргумент");
        if (Math.abs(Math.cos(a[0])) < 1e-10) {
            throw new ArithmeticException("Тангенс не существует для π/2 + πn, где n∈ℤ");
        }
        return Math.tan(a[0]);
    });

        operations.put("atan", a -> {
        if (a.length < 1) throw new IllegalArgumentException("Нужен 1 аргумент");
        return Math.atan(a[0]);
    });

        operations.put("atan2", (double... a) -> {
        if (a.length < 2) throw new IllegalArgumentException("Нужно 2 аргумента");
        return Math.atan2(a[0], a[1]);
    });

        operations.put("^", a -> {
        if (a.length < 2) throw new IllegalArgumentException();
        return Math.pow(a[0], a[1]);
    });

        operations.put("sqrt", a -> {
        if (a.length < 1) throw new IllegalArgumentException();
        if (a[0] < 0) throw new IllegalArgumentException("Квадратный корень из отрицательного числа в R не определён");
        return Math.sqrt(a[0]);
    });

        operations.put("%", a -> {
        if (a.length < 2) throw new IllegalArgumentException();
        if (a[1] == 0) throw new ArithmeticException("Деление на ноль");
        return a[0] * a[1] / 100;
    });

    }
    public IOperation getOperation(String op) {
        return operations.get(op);
    }

    public Set<String> getAvailableOperations() {
        return operations.keySet();
    }
}
