package org.example.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example")
public class WebCalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebCalculatorApplication.class, args);
    }
}
