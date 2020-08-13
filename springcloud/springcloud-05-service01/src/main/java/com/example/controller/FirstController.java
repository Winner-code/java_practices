package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/show")
    public String showInfo(){

        return "FirstController的showInfo方法执行！age值为";

    }

    @GetMapping("/showInfo")
    public String showInfo(int age,String name,@RequestHeader("myHeader") String header){
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "FirstController的showInfo方法执行！age值为："+age+"name的值为："+name+"header的值为："+header;

    }
}
