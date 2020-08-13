package com.example.controller;

import com.example.pojo.Student;
import com.example.service.ClientService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/test")
    public List<String> testFeign(){
        return clientService.testFeign();
    }

    @GetMapping("/getMultiParams")
    public Student getMultiParams(Integer age,String name){
        return clientService.getMultiParams(age, name);
    }
    @GetMapping("/postMultiParams")
    public Student postMultiParams(Integer age,String name){
        return clientService.postMultiParams(age, name);
    }
    @GetMapping("/postObjectParam")
    public Student postObjectParam(Student student){
        return clientService.postObjectParam(student);
    }


}
