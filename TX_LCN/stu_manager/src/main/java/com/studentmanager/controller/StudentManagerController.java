package com.studentmanager.controller;

import com.pojo.Student;
import com.studentmanager.service.StudentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentManagerController {
    @Autowired
    private StudentManagerService studentManagerService;
    @RequestMapping("/createStudent")
    public Student createStudent(Student student){
        System.out.println("学生管理控制器");
        return studentManagerService.register(student);
    }
    @RequestMapping("/findById")
    public Student findById(Long id){
        System.out.println("学生管理控制器");
        return studentManagerService.findById(id);
    }
}
