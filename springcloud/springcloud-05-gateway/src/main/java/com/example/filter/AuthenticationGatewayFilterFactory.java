package com.example.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 登录校验过滤器工厂
 * 泛型是此工厂构造时自动注入的配置对象。此配置对象由Spring容器提供。
 * 根据配置文件中提供的后置配置内容，自动进行配置。
 * 如： 当前类型中定义Config有一个属性token，此属性为字符串类型。那么对应的配置是， Authentication=xxx，xxx就是要传递的token属性值。
 * 在当前实现中，Config中的token属性即是请求参数中用于标明登录标记的请求参数名。
 */

@Component
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {
    public AuthenticationGatewayFilterFactory() {
        super(AuthenticationGatewayFilterFactory.Config.class);
    }

    /**
     * Spring构造Config对象时，读取的配置文件数据对应Config对象中的哪一个属性，即property命名。
     * @return
     */

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("tokenName");
    }

    //完成核心过滤业务逻辑
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            //ServerWebExchange命名为服务网络交换器，存放着重要的请求-响应属性、请求实例和响应实例等等
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String token = exchange.getRequest().getQueryParams().getFirst(config.getTokenName());
                //请求头中不存在token，用户未登录，返回登录。
                if(token == null || token.isEmpty()){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();

                }
                // 用户已登录，进入后续执行流程
                return chain.filter(exchange);
            }
        };
    }

    public static  class Config{
        private String tokenName;

        public String getTokenName() {
            return tokenName;
        }

        public void setTokenName(String tokenName) {
            this.tokenName = tokenName;
        }
    }
}
