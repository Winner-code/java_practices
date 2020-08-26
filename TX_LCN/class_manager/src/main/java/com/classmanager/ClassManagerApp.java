package com.classmanager;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDistributedTransaction//开启分布式事务支持
@MapperScan(basePackages = "com.classmanager.mapper")
public class ClassManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ClassManagerApp.class,args);
    }
}
