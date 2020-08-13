package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * @EnableConfigServer - 开启配置中心服务端。
 * 应用会根据全局配置文件访问GIT远程仓库，并将远程仓库中的配置内容下载到本地。
 */
@SpringBootApplication
@EnableConfigServer
public class Springcloud04ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud04ConfigServerApplication.class, args);
    }

}
