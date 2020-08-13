package com.example.controller;

import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;
    @RequestMapping("/getMsg")
    public String getMsg(String str){
        return demoService.showMsg(str);
    }
}
