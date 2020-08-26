package com.classmanager.controller;

import com.classmanager.service.ClassManagerService;
import com.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassManagerController {
    @Autowired
    private ClassManagerService classesManagerService;
    @RequestMapping("/createClass")
    public Classes createClass(Classes classes){
        System.out.println("班级管理系统-创建班级："+classes);
        return classesManagerService.createClass(classes);
    }

    @RequestMapping("/getClassById")
    public Classes getClassById(Long id){
        System.out.println("班级管理系统-主键查询班级："+id);
        return classesManagerService.getClassById(id);
    }
}
