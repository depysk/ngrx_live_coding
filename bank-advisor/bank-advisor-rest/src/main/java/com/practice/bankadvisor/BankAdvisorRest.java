package com.practice.bankadvisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.practice.bankadvisor")
public class BankAdvisorRest {
    public static void main(String[] args) {
        SpringApplication.run(BankAdvisorRest.class, args);
    }
}
