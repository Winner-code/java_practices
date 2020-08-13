package com.eureka.springcloud00eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Springcloud00EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud00EurekaApplication.class, args);
    }

}
