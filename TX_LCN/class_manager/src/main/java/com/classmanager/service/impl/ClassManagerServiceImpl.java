package com.classmanager.service.impl;

import com.classmanager.mapper.ClassMapper;
import com.classmanager.service.ClassManagerService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClassManagerServiceImpl implements ClassManagerService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    @Transactional
    @LcnTransaction
    public Classes createClass(Classes classes) {
        System.out.println("班级管理系统-服务实现-新增班级前："+classes);

        classes.setId(System.nanoTime());

        int rows = classMapper.insertClass(classes);
        if(rows != 1){
            throw new RuntimeException("新增班级错误");
        }
        System.out.println("班级管理系统-服务实现-新增班级后："+classes);

        return classes;
    }
    @Override
    public Classes getClassById(Long id) {
        System.out.println("班级管理系统-服务实现-主键查询班级："+id);

        return classMapper.selectById(id);
    }
}
