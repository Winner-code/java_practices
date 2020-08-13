package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/**
 * @EnableFeignClients - 描述当前应用是一个使用Openfeign技术开发的服务消费端。
 *  属性 backPackage - 扫描的包，即使用@FeignClient描述的接口所在包。此属性可省略，默认扫描当前工程所有包。
 */
/**
 * @EnableCircuitBreaker - 开启Hystrix容错处理能力。
 *  如果不使用此注解，服务代码中的@HystrixCommand注解无效。
 *  且Hystrix相关监控数据无法收集。
 * @EnableHystrixDashboard - 开启Hystrix Dashboard监控仪表盘。
 */

@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Springcloud03ConsumerFeignHytrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud03ConsumerFeignHytrixApplication.class, args);
    }

}
