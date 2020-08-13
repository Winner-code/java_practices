package com.example.service.impl;

import com.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientServiceImpl implements ClientService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Override
    public String first() {
        ServiceInstance si = this.loadBalancerClient.choose("application-service");
        // 拼接访问服务的 URL http://ip:port/
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/");
        System.out.println("本次访问的 service 是： " + sb.toString());
        RestTemplate rt = new RestTemplate();

        ResponseEntity<String> response = rt.exchange(sb.toString(), HttpMethod.GET, null, String.class);
        String result = response.getBody();
        return result;
    }
}
