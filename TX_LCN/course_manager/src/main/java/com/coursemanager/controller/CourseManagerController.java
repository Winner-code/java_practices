package com.coursemanager.controller;

import com.coursemanager.service.CourseManagerService;
import com.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseManagerController {
    @Autowired
    private CourseManagerService service;
    @RequestMapping("/createCrouse")
    public Course createCourese(Course course){
        return service.createCourse(course);
    }
}
