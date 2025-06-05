package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("op: ");
            String op = scanner.nextLine().trim().toLowerCase();
            if (op.equals("exit")) {
                break;
            }

            System.out.println("args: ");
            String[] argTokens  = scanner.nextLine().trim().split("//s+");
            double[] argsParsed = Arrays.stream(argTokens).mapToDouble(Double::parseDouble).toArray();


        }

    }
}
