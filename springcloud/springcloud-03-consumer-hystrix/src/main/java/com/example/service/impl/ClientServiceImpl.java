package com.example.service.impl;



import com.example.service.ClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
/**
 * 在类上，增加@CacheConfig注解，用来描述当前类型可能使用cache缓存。
 * 如果使用缓存，则缓存数据的key的前缀是cacheNames。
 * cacheNames是用来定义一个缓存集的前缀命名的，相当于分组。
 */

@CacheConfig(cacheNames = "test.hystrix.caches")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    @HystrixCommand(fallbackMethod = "myFallBack",commandProperties = {
            // 默认20个;10s内请求数大于20个时就启动熔断器，当请求符合熔断条件时将触发fallback逻辑
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value ="10" ),
            // 请求错误率大于50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value ="50" ),
            // 默认5秒;熔断多少秒后去尝试请求
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value ="5" )

    })
    public String getInfo() {
        ServiceInstance si = loadBalancerClient.choose("application-provider");
        //创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        // 拼接访问服务的URL  http://ip:port/
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost()).append(":").append(si.getPort());

        ResponseEntity<String> response = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    /**
     * @Cacheable - 将当期方法的返回值缓存到cache中。
     *  只要方法增加了@Cacheable注解，每次调用当前方法的时候，spring cloud都会先访问cache获取数据，
     *  如果cache中没有数据，则访问远程服务获取数据。远程服务返回数据，先保存在cache中，再返回给客户端。
     *  如果cache中有数据，则直接返回cache中的数据，不会访问远程服务。
     *  请求缓存会有缓存数据不一致的可能。缓存数据过期、失效、脏数据等情况。
     *  一旦使用了请求缓存来处理幂等性请求操作。则在非幂等性请求操作中必须管理缓存。避免缓存数据的错误。
     * @return
     */

    @Override
    @Cacheable("myCache")
    public String testGet() {
        ServiceInstance si = loadBalancerClient.choose("application-provider");
        //创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        // 拼接访问服务的URL  http://ip:port/
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/testGet");

        ResponseEntity<String> response = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    /**
     * @CacheEvict - 管理缓存。根据参数key删除缓存中对应的缓存数据。
     * @return
     */
    @Override
    @CacheEvict("myCache")
    public String testPost() {
        ServiceInstance si = loadBalancerClient.choose("application-provider");
        //创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        // 拼接访问服务的URL  http://ip:port/
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/testPost");

        ResponseEntity<String> response = restTemplate.exchange(sb.toString(), HttpMethod.POST, null, String.class);
        return response.getBody();
    }

    public String myFallBack(){
        return "服务降级回调方法执行！";
    }
}
