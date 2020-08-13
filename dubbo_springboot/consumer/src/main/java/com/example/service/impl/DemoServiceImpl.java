package com.example.service.impl;

import com.example.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Reference
    private DemoService demoService;

    @Override
    public String showMsg(String str) {
        return demoService.showMsg("consumer");
    }
}
