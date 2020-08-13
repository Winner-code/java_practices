package com.example.servic.impl;

import com.example.service.DubboService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class DubboServiceImpl implements DubboService {
    @Override
    public String showInfo(String str) {
        return "provider"+str;
    }
}
