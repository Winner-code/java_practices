package com.example.controller;


import com.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public String showInfo(){
        return clientService.getInfo();
    }
    @GetMapping("testGet")
    public String testGet(){
        return clientService.testGet();
    }
    @GetMapping("testPost")
    public String testPost(){
        return clientService.testPost();
    }
}
