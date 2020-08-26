package com.studentmanager.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.pojo.Classes;
import com.pojo.Course;
import com.pojo.Student;
import com.studentmanager.feignclient.ClassManagerFeignClient;
import com.studentmanager.feignclient.CourseManagerFeignClient;
import com.studentmanager.mapper.StudentMapper;
import com.studentmanager.service.StudentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service

public class StudentManagerServiceImpl implements StudentManagerService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassManagerFeignClient classManagerFeignClient;
    @Autowired
    private CourseManagerFeignClient courseManagerFeignClient;

    @Transactional(rollbackFor = RuntimeException.class)
    @LcnTransaction
    public Student register(Student student) {
        //远程服务调用 cid为null 需要创建一个班级
        if(null == student.getCid()){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String className = "新建班级-"+simpleDateFormat.format(date);
            Classes aClass = classManagerFeignClient.createClass(className, System.nanoTime());
            student.setId(System.nanoTime());
            student.setCid(aClass.getId());
        }
        System.out.println("学生管理-服务实现-");

        student.setId(System.nanoTime());
        int i = studentMapper.insertStduent(student);
        if(i!=1){
            throw  new RuntimeException("新增学生错误");
        }
        Course course = courseManagerFeignClient.createCourse("中国计算机课程");
        if(course == null){
            throw new RuntimeException("新增课程出现错误");
        }
        int r = new Random().nextInt(1000) % 2;
        if(r == 1){
            throw new RuntimeException("测试新增学生错误，班级回滚");
        }
        return student;
    }

    public Student findById(Long id) {
        System.out.println("学生管理-服务实现-");
        return studentMapper.selectById(id);
    }

}
