package com.example.service;

import com.example.service.impl.ClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "application-provider",fallback = ClientServiceImpl.class)
public interface ClientService extends ServiceApi {
}
