package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
/**
 * 本地接口，继承服务标准接口。
 * 在接口上增加注解@FeignClient，代表当前接口是一个 Openfeign 技术中的服务消费端。
 * 属性 name|value - 代表当前的 FeignClient 在请求 application service 的时候，是访问哪一个服务
 * 所谓的哪一个服务，就是 application service 全局配置文件中的spring.application.name 属性值。
 */
//服务的提供方，yml配置文件中的spring.application.name
@FeignClient("application-provider")
public interface ClientService extends ServiceApi {
}
