package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServiceController {
//    从远程配置文件中获取value值
//    @Value("${test.str}")
//    private String str;
    @PostMapping("/testPost")
    public Object testPost(){
        System.out.println("testPost method run");
        return "写操作返回";
    }

    @GetMapping("/testGet")
    public Object testGet(){
//        System.out.println("testGet method run"+str);
          System.out.println("testGet method run");

        return "读操作返回";
    }

    @GetMapping
    public Object showInfo(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "测试Spring Cloud Config Clienr";
    }
}
