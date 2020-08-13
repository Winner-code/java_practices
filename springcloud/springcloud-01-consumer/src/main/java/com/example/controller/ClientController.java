package com.example.controller;

import com.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public Object first(){
        return this.clientService.first();
    }
}
