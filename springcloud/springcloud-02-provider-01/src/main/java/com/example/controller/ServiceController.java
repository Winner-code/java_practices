package com.example.controller;

import com.example.pojo.Student;
import com.example.service.ServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ServiceController implements ServiceApi {
    @GetMapping
    public String showInfo(){
        return "test spring boot";
    }

    @Override
    public List<String> testFeign() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList("测试Openfeign", "此为返回结果");
    }

    @Override
    public Student getMultiParams(Integer age, String name) {
        System.out.println("getMultiParams method run, parameters is [ age : " + age + " ; name : " + name + " ]");
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        return student;
    }

    @Override
    public Student postMultiParams(Integer age, String name) {
        System.out.println("postMultiParams method run, parameters is [ age : " + age + " ; name : " + name + " ]");
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        return student;
    }

    @Override
    public Student postObjectParam(Student pojo) {
        System.out.println("postObjectParam method run, parameters is" +pojo);
        return pojo;
    }
}
