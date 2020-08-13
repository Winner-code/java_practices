package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    @PostMapping("/testPost")
    public Object testPost(){
        System.out.println("testPost method run");
        return "写操作返回";
    }

    @GetMapping("/testGet")
    public Object testGet(){
        System.out.println("testGet method run");
        return "读操作返回";
    }
    @GetMapping
    public String showInfo(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test spring boot";
    }
}
