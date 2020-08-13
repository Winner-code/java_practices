package com.rabbit.fanoutsender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.entity.User;

/**
 * 发送消息类型。消息发送到fanout交换器中。
 * 交换器名称是： ex-fanout
 */
@Component
public class UserMessageSender {
    @Autowired
    private AmqpTemplate template;

    /**
     * 发送消息方法。
     * @param user
     */
    public void send(User user){
        this.template.convertAndSend("ex-fanout", "", user);
    }
}
