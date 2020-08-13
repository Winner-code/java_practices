package com.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息的类型
 * 把消息发送到RabbitMQ中
 * 在spring-boot-starter-amqp中，启动器自动创建初始化一个AmqpTemplate，
 * 作为访问Amqp消息服务器（MQ中间件）的客户端对象。
 */
@Component
public class LogMessageSender {
    @Autowired
    private AmqpTemplate template;

    /**
     * 发送消息的方法。
     * template.convertAndSend(String exchange, String routingKey, Object message)
     * exchange - 交换器名称
     * routingKey - 路由键
     * message - 要发送的消息内容，就是传递的消息对象的消息体。
     */
    public void sendMessage(String exchange, String routingKey, String message){
        this.template.convertAndSend(exchange, routingKey, message);
    }
}
