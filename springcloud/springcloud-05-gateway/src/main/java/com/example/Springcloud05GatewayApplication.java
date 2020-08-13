package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class Springcloud05GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud05GatewayApplication.class, args);
    }

}
