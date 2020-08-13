package com.example.service.impl;

import com.example.pojo.Student;
import com.example.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public List<String> testFeign() {
        return Arrays.asList("testFeign返回托底数据");
    }

    @Override
    public Student getMultiParams(Integer age, String name) {
        return null;
    }

    @Override
    public Student postMultiParams(Integer age, String name) {
        return null;
    }

    @Override
    public Student postObjectParam(Student pojo) {
        return null;
    }
}
