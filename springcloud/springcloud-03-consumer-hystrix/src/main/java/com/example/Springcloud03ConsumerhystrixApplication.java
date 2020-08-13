package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
/**
 * @EnableCircuitBreaker - 开启 Hystrix 容错处理能力。
 * 如果不使用此注解，服务代码中的@HystrixCommand 注解无效。
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableCaching
public class Springcloud03ConsumerhystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud03ConsumerhystrixApplication.class, args);
    }

}
